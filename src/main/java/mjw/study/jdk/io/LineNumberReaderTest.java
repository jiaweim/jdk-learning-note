package mjw.study.jdk.io;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * BufferedReader的子类，与BufferedReader的唯一差别是，记录了行号。
 *
 * @author JiaweiMao
 * @date Dec 28, 2015 2:50:19 PM
 */
class LineNumberReaderTest
{
    private LineNumberReader reader;

    @BeforeAll
    void setUp()
    {
        String string = "BEGIN IONS\n"
                + "TITLE=File5753 Spectrum1 scans: 184\n"
                + "PEPMASS=489.0551500000	0.0000000000\n"
                + "CHARGE=3+\n"
                + "SCANS=184\n"
                + "RTINSECONDS=650.00\n"
                + "126.0776200000	1156.2000000000\n"
                + "END IONS\n"
                + "\n"
                + "BEGIN IONS\n"
                + "TITLE=File5753 Spectrum2 scans: 326\n"
                + "PEPMASS=409.2793600000	53394.2265600000\n"
                + "CHARGE=2+\n"
                + "SCANS=326\n"
                + "RTINSECONDS=688.00\n"
                + "101.0603600000	16683.2000000000\n"
                + "264.5106200000	1168.8600000000\n"
                + "END IONS\n";
        reader = new LineNumberReader(new StringReader(string));
    }

    /**
     * 获得当前行号
     */
    @Test
    void testGetLineNumber()
    {
        assertEquals(0, reader.getLineNumber());
        reader.setLineNumber(100);
        assertEquals(100, reader.getLineNumber());
    }

    /**
     * Mark当前位置，之后调用reset，重置到Mark的位置。
     *
     * @throws IOException
     */
    @Test
    void testMark() throws IOException
    {
        assertEquals('B', (char) reader.read());
        assertEquals('E', (char) reader.read());
        reader.mark(0);
        assertEquals('G', (char) reader.read());
        assertEquals('I', (char) reader.read());
        reader.reset();
        assertEquals('G', (char) reader.read());
    }

    @AfterAll
    void tearDown() throws IOException
    {
        reader.close();
    }

}
