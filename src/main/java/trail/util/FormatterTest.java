package trail.util;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * C的printf 风格格式化字符串的Java 实现。
 *
 * @author JiaweiM
 * @date Aug 13, 2015 10:59:28 AM
 */
public class FormatterTest
{

    @Test
    public void testDate()
    {
        Calendar c = new GregorianCalendar();
        String s = String.format("Duke's Birthday: %1$tm %1$te,%1$tY", c);
        System.out.println(s);
    }

    @Test
    public void testFormat()
    {
        Formatter fmt = new Formatter();
        fmt.format("Copying file%nThansfer is %d%% complete", 88);
//		assertEquals("Copying file\nThansfer is 88% complete", fmt.toString());
//		System.out.println(fmt.toString());
        String format = fmt.toString();
        String exp = "Copying file\n Thansfer is 88% complete";
        char[] actual = format.toCharArray();
        System.out.println(actual.length);
        System.out.println(exp.length());
        for (int i = 0; i < actual.length; i++) {
            char c = actual[i];
            if (c != exp.charAt(i)) {
                System.out.println("index=" + i + c + "!=" + exp.charAt(i));
            }
        }
//		System.out.println("Copying file\nThansfer is 88% complete");
        fmt.close();
    }

    @Test
    public void testFormat2()
    {
        Formatter fmt = new Formatter();
        fmt.format("|%f|%n|%12f|%n|%012f", 10.12345, 10.12345, 10.12345);
        System.out.println(fmt);
        fmt.close();
    }

    @Test
    public void testFormat3()
    {
        Formatter fmt;
        for (int i = 1; i <= 10; i++) {
            fmt = new Formatter();
            fmt.format("%4d%4d%4d", i, i * i, i * i * i);
            System.out.println(fmt);
            fmt.close();
        }
    }

    @Test
    public void testFormat4()
    {
        Formatter fmt = new Formatter();

        // Format 4 decimal places.
        fmt.format("%.4f", 123.1234567);
        System.out.println(fmt);
        fmt.close();

        // Format to 2 decimal places in a 16 character field
        fmt = new Formatter();
        fmt.format("%16.2e", 123.1234567);
        System.out.println(fmt);
        fmt.close();

        // Display at most 15 characters in a string.
        fmt = new Formatter();
        fmt.format("%.15s", "Formatting with Java is now easy.");
        System.out.println(fmt);
        fmt.close();
    }

    @Test
    public void testFormat5()
    {
        Calendar cal = Calendar.getInstance();
        Formatter fmt = new Formatter();
        fmt.format("Today is day %Te of %<tB %<tY", cal);
        System.out.println(fmt);
        fmt.close();
    }

    @Test
    public void testFormat6()
    {
        Formatter fmt = new Formatter();

        // Right justify by default
        fmt.format("|%10.2f|", 123.123);
        System.out.println(fmt);
        fmt.close();

        // Now, left justify.
        fmt = new Formatter();
        fmt.format("|%-10.2f|", 123.123);
        System.out.println(fmt);
        fmt.close();
    }

    @Test
    public void testFormat7()
    {
        Formatter fmt = new Formatter();
        fmt.format("% d", -100);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("% d", 100);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("% d", -200);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("% d", 200);
        System.out.println(fmt);
        fmt.close();
    }

    StringBuilder sb;
    Formatter formatter;

    @BeforeAll
    public void setup()
    {
        sb = new StringBuilder();
        formatter = new Formatter(sb, Locale.US);
    }

    @AfterAll
    public void tearDown()
    {
        formatter.close();
    }

    /**
     * Explicit indexing is used when the format specifier contains an argument index.
     * The argument index is a decimal integer indicating the position of the argument
     * in the argument list. The first argument is referenced by "1$", the second by "2$", etc.
     * An argument may be referenced more than once.
     */
    @Test
    public void testArgExplicitIndex()
    {
        formatter.format("%4$s %3$s %2$s %1$s %4$s %3$s %2$s %1$s", "a", "b", "c", "d");
        assertEquals("d c b a d c b a", sb.toString());
    }

    /**
     * Relative indexing is used when the format specifier contains a '<' ('\u003c') flag
     * which causes the argument for the previous format specifier to be re-used.
     * If there is no previous argument, then a MissingFormatArgumentException is thrown.
     */
    @Test
    public void testArgRelativeIndex()
    {
        formatter.format("%s %s %<s %<s", "a", "b", "c", "d");
        assertEquals("a b b b", sb.toString());
    }

    /**
     * Ordinary indexing is used when the format specifier contains neither an argument
     * index nor a '<' flag. Each format specifier which uses ordinary indexing is
     * assigned a sequential implicit index into argument list which is independent
     * of the indices used by explicit or relative indexing.
     */
    @Test
    public void testArgOrdinaryIndex()
    {
        formatter.format("%s %s %s %s", "a", "b", "c", "d");
        assertEquals("a b c d", sb.toString());
    }

    @Test
    public void testGeneral()
    {
        formatter.format("Formatting %s is easy %d %f", "with Java", 10, 98.6);
        //System.out.println(sb.toString());
        assertEquals("Formatting with Java is easy 10 98.600000", sb.toString());
    }

    @Test
    public void testgFlag()
    {
        for (double i = 1000; i < 1.0e+10; i *= 100) {
            formatter.format("%g", i);
            System.out.println(sb.toString());
        }
    }

    @Test
    public void testCalendar()
    {
        Calendar cal = Calendar.getInstance();

        // Display standard 12-hour time format.
        formatter.format("%tr", cal);
        System.out.println(formatter);
        formatter.close();

        // Display complete time and date information.
        formatter = new Formatter();
        formatter.format("%tc", cal);
        System.out.println(formatter);
        formatter.close();

        // Display just hour and minute.
        formatter = new Formatter();
        formatter.format("%tl:%tM", cal, cal);
        System.out.println(formatter);
        formatter.close();

        // Display month by name and number.
        formatter = new Formatter();
        formatter.format("%tB %tb %tm", cal, cal, cal);
        System.out.println(formatter);
    }
}
