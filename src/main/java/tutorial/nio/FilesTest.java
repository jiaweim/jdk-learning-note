/*
 * Copyright 2018 JiaweiMao jiaweiM_philo@hotmail.com
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

package tutorial.nio;

import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 02 Oct 2019, 3:08 PM
 */
public class FilesTest
{

    @Test
    public void testNewDirectoryStream() throws IOException
    {
        DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("D:\\data"));
        for (Path path : stream) {
            System.out.println(path);
        }
    }

    @Test
    public void testNewDirectoryStreamGlob() throws IOException
    {
        DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get("D:\\doc"), "*.pptx");
        for (Path path : paths) {
            System.out.println(path);
        }

    }

    @Test
    public void testCopy()
    {

    }

    @Test
    public void testGetLastModifiedTime() throws URISyntaxException
    {
        URL res = getClass().getClassLoader().getResource("sample.txt");
        Path path = Paths.get(res.toURI());


    }

    @Test
    public void testCreateFile() throws IOException
    {
        Path path = Paths.get("test.txt");
        Path out = Files.createFile(path);
        assertTrue(Files.exists(out));
        Files.delete(out);
    }

    @Test
    public void testWrite() throws IOException
    {
        Path path = Paths.get("test.tmp");
        String content = "Hello";
        Path out = Files.write(path, content.getBytes());

        byte[] bytes = Files.readAllBytes(out);
        assertEquals(content, new String(bytes));

        Files.delete(path);
    }

    @Test
    public void testReadAllLines() throws URISyntaxException, IOException
    {
        URL res = getClass().getClassLoader().getResource("sample.txt");
        Path path = Paths.get(res.toURI());

        List<String> strings = Files.readAllLines(path);
        assertEquals(strings.get(4), "line5");
    }

    @Test
    public void testReadAllBytes() throws URISyntaxException, IOException
    {
        URL res = getClass().getClassLoader().getResource("sample.txt");
        Path path = Paths.get(res.toURI());
        byte[] bytes = Files.readAllBytes(path);
        assertEquals(bytes[0], 'l');
        assertEquals(bytes[1], 'i');
        assertEquals(bytes[2], 'n');
        assertEquals(bytes[3], 'e');

        String content = new String(bytes);
        assertTrue(content.startsWith("line1"));

    }

    @Test
    public void testTry()
    {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(""), StandardCharsets.US_ASCII)) {
            writer.write("hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTryFinally() throws IOException
    {
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(Paths.get(""), StandardCharsets.US_ASCII);
            writer.write("hello");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
