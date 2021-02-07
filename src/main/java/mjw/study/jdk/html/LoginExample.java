package mjw.study.jdk.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Summary :
 * <p>
 * Send an HTTP “GET” request to Google login form – https://accounts.google.com/ServiceLoginAuth
 * Analyze the form data via Google Chrome’s “Network” feature. Alternatively, you can view the HTML source code.
 * Use jSoup library to extract all visible and hidden form’s data, replace with your username and password.
 * Send a HTTP “POST” request back to login form, along with the constructed parameters
 * After user authenticated, send another HTTP “GET” request to Gmail page. https://mail.google.com/mail/
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 04 Nov 2019, 8:08 AM
 */
public class LoginExample
{
    private List<String> cookies;
    private HttpsURLConnection conn;

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception
    {
        String url = "http://119.78.130.199/sportfield/login.php";
        String gmail = "http://119.78.130.199/sportfield/field.php";

        LoginExample http = new LoginExample();
        // make sure cookies is turn on
        CookieHandler.setDefault(new CookieManager());

        // 1. Send a "GET" request, so that you can extract the form's data.
//        String page = http.GetPageContent(url);
        String postParams = http.getFormParams1(url, "liya@dicp.ac.cn", "jiejiayouo521");

        // 2. Construct above post's content and then send a POST request for authentication
        http.sendPost(url, postParams);

        // 3. success then go to gmail.
        String result = http.GetPageContent(gmail);
        System.out.println(result);
    }

    private void sendPost(String url, String postParams) throws Exception
    {
        URL obj = new URL(url);
        conn = (HttpsURLConnection) obj.openConnection();

        // Acts like a browser
        conn.setUseCaches(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Host", "accounts.google.com");
        conn.setRequestProperty("User-Agent", USER_AGENT);
        conn.setRequestProperty("Accept",
                "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        for (String cookie : this.cookies) {
            conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
        }
        conn.setRequestProperty("Connection", "keep-alive");
        conn.setRequestProperty("Referer", "https://accounts.google.com/ServiceLoginAuth");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", Integer.toString(postParams.length()));

        conn.setDoOutput(true);
        conn.setDoInput(true);

        // Send post request
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(postParams);
        wr.flush();
        wr.close();

        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + postParams);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        // System.out.println(response.toString());
    }

    private String GetPageContent(String url) throws Exception
    {
        URL obj = new URL(url);
        conn = (HttpsURLConnection) obj.openConnection();

        // default is GET
        conn.setRequestMethod("GET");
        conn.setUseCaches(false);

        // act like a browser
        conn.setRequestProperty("User-Agent", USER_AGENT);
        conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        if (cookies != null) {
            for (String cookie : this.cookies) {
                conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
            }
        }
        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Get the response cookies
        setCookies(conn.getHeaderFields().get("Set-Cookie"));

        return response.toString();

    }


    public String getFormParams1(String url, String username, String password) throws IOException
    {
        Document doc = Jsoup.connect(url).get();

        Element emailUser = doc.getElementById("emailUser");
        Element emailPass = doc.getElementById("emailPass");
        Elements button = doc.getElementsByTag("button");

        List<String> param = new ArrayList<>();
        param.add("emailUser=" + URLEncoder.encode(username, "UTF-8"));
        param.add("emailPass=" + URLEncoder.encode(password, "UTF-8"));
        StringBuilder result = new StringBuilder();
        for (String s : param) {
            if (result.length() == 0) {
                result.append(s);
            } else {
                result.append("&" + s);
            }
        }

        return result.toString();
    }

    public String getFormParams(String html, String username, String password)
            throws UnsupportedEncodingException
    {
        System.out.println("Extracting form's data...");

        Document doc = Jsoup.parse(html);

        // Google form id
        Element loginform = doc.getElementById("gaia_loginform");
        Elements inputElements = loginform.getElementsByTag("input");
        List<String> paramList = new ArrayList<>();
        for (Element inputElement : inputElements) {
            String key = inputElement.attr("name");
            String value = inputElement.attr("value");

            if (key.equals("Email"))
                value = username;
            else if (key.equals("Passwd"))
                value = password;
            paramList.add(key + "=" + URLEncoder.encode(value, "UTF-8"));
        }

        // build parameters list
        StringBuilder result = new StringBuilder();
        for (String param : paramList) {
            if (result.length() == 0) {
                result.append(param);
            } else {
                result.append("&" + param);
            }
        }
        return result.toString();
    }

    public List<String> getCookies()
    {
        return cookies;
    }

    public void setCookies(List<String> cookies)
    {
        this.cookies = cookies;
    }

}
