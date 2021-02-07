package mjw.study.jdk.nio;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void testCopy() throws IOException
    {
//        Files.createTempFile()
        File tempFile = File.createTempFile("file", null);
        System.out.println(tempFile);
    }

    @Test
    public void testGetLastModifiedTime() throws URISyntaxException
    {
        URL res = getClass().getClassLoader().getResource("sample.txt");
        Path path = Paths.get(res.toURI());

        System.out.println(System.getProperty("java.io.tmpdir"));

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
    void testCreateTempFile() throws IOException
    {
        Path tempFile = Files.createTempFile("happy", ".lucky");
        System.out.println(tempFile);

        Path tempFile2 = Files.createTempFile(null, ".lucky");
        System.out.println(tempFile2);

        Path tempFile3 = Files.createTempFile("happy", null);
        System.out.println(tempFile3);

        Path tempFile4 = Files.createTempFile("happy", "");
        System.out.println(tempFile4);
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
