/*
 * Copyright 2017 JiaweiMao jiaweiM_philo@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tutorial.net;

import org.testng.annotations.Test;

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
public class URLTest
{

    @Test
    public void testCtr()
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
