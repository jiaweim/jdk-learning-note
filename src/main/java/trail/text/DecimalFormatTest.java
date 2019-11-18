package trail.text;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiMao
 * @date Jan 6, 2016 2:40:14 PM
 */
public class DecimalFormatTest
{
    static public void customFormat(String pattern, double value)
    {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        System.out.println(value + "  " + pattern + "  " + output);
    }

    static public void localizedFormat(String pattern, double value, Locale loc)
    {
        NumberFormat nf = NumberFormat.getNumberInstance(loc);
        DecimalFormat df = (DecimalFormat) nf;
        df.applyPattern(pattern);
        String output = df.format(value);
        System.out.println(pattern + "  " + output + "  " + loc.toString());
    }

    static public void main(String[] args)
    {
        customFormat("###,###.###", 123456.789);
        customFormat("###.##", 123456.789);
        customFormat("000000.000", 123.78);
        customFormat("$###,###.###", 12345.67);
        customFormat("\u00a5###,###.###", 12345.67);

        Locale currentLocale = new Locale("en", "US");

        DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols(currentLocale);
        unusualSymbols.setDecimalSeparator('|');
        unusualSymbols.setGroupingSeparator('^');
        String strange = "#,##0.###";
        DecimalFormat weirdFormatter = new DecimalFormat(strange, unusualSymbols);
        weirdFormatter.setGroupingSize(4);
        String bizarre = weirdFormatter.format(12345.678);
        System.out.println(bizarre);

        Locale[] locales = {new Locale("en", "US"), new Locale("de", "DE"), new Locale("fr", "FR")};

        for (int i = 0; i < locales.length; i++) {
            localizedFormat("###,###.###", 123456.789, locales[i]);
        }
    }

    @Test
    void testPrefix()
    {
        NumberFormat format = new DecimalFormat("%");
    }

    @Test
    void testScientific()
    {
        NumberFormat format = new DecimalFormat("0.######E0");
        assertEquals(format.format(Integer.MAX_VALUE), "2.147484E9");
        assertEquals(format.format(Integer.MIN_VALUE), "-2.147484E9");

        format = new DecimalFormat("0.#####E0");
        assertEquals(format.format(Integer.MAX_VALUE), "2.14748E9");
        assertEquals(format.format(Integer.MIN_VALUE), "-2.14748E9");
        assertEquals(format.format(0.12345), "1.2345E-1");

        format = new DecimalFormat("000000E0");
        assertEquals(format.format(0.12345), "123450E-6");

        format = new DecimalFormat("##0.#####E0");
        assertEquals(format.format(12345), "12.345E3");
        assertEquals(format.format(123456), "123.456E3");

        double vl = 3e18;
        format = new DecimalFormat("0.0#E0");
        System.out.println(format.format(vl));
    }
}
