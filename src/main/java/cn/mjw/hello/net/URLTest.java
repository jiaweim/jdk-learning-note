package cn.mjw.hello.net;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.23, 10:52 AM
 */
class URLTest
{
    @Test
    void testCtr()
    {
        try {
            URL myUni = new URL("http://www.dicp.cas.cn/");
            System.out.println(myUni.toExternalForm());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCtr2()
    {
        try {
            URL myurl = new URL("http://www.dicp.cas.cn/");
            URL aweb = new URL(myurl, "gkjj/skjj/");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testCtr3()
    {
        try {
            URL utl = new URL("http", "www.dicp.cas.cn", "gkjj/skjj/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCtr4()
    {
        try {
            URL url = new URL("http", "www.cumt.edu.cn", 80, "/mydoc.html");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetFile()
    {
        try {
            URL url = new URL("http://www.dicp.cas.cn/gkjj/xrld/");
            DataInputStream din = new DataInputStream(url.openStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(din));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            din.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * to fetch contents of the resource
     */
    @Test
    public void testOpenStream() throws IOException
    {
        URL url = new URL("https://www.baidu.com/");
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }

}
