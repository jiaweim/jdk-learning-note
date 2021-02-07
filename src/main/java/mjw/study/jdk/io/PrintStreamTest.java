package mjw.study.jdk.io;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiM
 * @date Nov 14, 2015 3:52:09 PM
 */
public class PrintStreamTest
{
    @Test
    public void testPrintf() throws FileNotFoundException
    {
        ByteArrayOutputStream baOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baOutputStream);
        ps.printf("%s! Welcome to use PrintStream!\n", "jiawei");
        ps.close();
        assertEquals("jiawei! Welcome to use PrintStream!\n", baOutputStream.toString());
    }
}
