package cn.mjw.hello.io;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.11.02, 8:59 PM
 */
class BufferedReaderTest
{
    @Test
    void close() throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(BufferedReaderTest.class.getClassLoader()
                .getResource("afile.txt").getFile()));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();

        System.out.println(reader.readLine());
    }

    @Test
    void testReset() throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(BufferedReaderTest.class.getClassLoader()
                .getResource("afile.txt").getFile()));
        String line;
        reader.reset();
        reader.mark(0);
        while ((line = reader.readLine()) != null) {

        }
    }

}
