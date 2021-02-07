package mjw.study.jdk.io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiM
 * @date Sep 1, 2015 9:08:18 AM
 */
class RandomAccessFileTest
{
    @Test
    void test2() throws FileNotFoundException
    {
        String file = "text.dat";
        RandomAccessFile rf = new RandomAccessFile(file, "w");

    }

    @Test
    void test() throws IOException
    {
        File file = new File("test");
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.writeInt(1);
        raf.writeInt(2);
        raf.writeInt(3);

        assertEquals(raf.getFilePointer(), 12);

        raf.seek(0);
        assertEquals(raf.getFilePointer(), 0);

        int i = raf.readInt();
        assertEquals(i, 1);
        assertEquals(raf.getFilePointer(), 4);

        raf.close();

        file.deleteOnExit();
    }

}
