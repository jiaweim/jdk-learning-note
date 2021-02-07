package mjw.study.jdk.text;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiMao
 * @date Jan 6, 2016 2:00:18 PM
 */
public class NumberFormatDemo
{
    Locale fr = Locale.FRANCE;
    Locale de = Locale.GERMANY;
    Locale us = Locale.US;

    static public void displayNumber(Locale currentLocale)
    {
        Integer quantity = new Integer(123456);
        Double amount = new Double(345987.246);
        NumberFormat numberFormatter;
        String quantityOut;
        String amountOut;

        numberFormatter = NumberFormat.getNumberInstance(currentLocale);
        quantityOut = numberFormatter.format(quantity);
        amountOut = numberFormatter.format(amount);
        System.out.println(quantityOut + "   " + currentLocale.toString());
        System.out.println(amountOut + "   " + currentLocale.toString());
    }

    static public void displayCurrency(Locale currentLocale)
    {
        Double currencyAmount = new Double(9876543.21);
        Currency currentCurrency = Currency.getInstance(currentLocale);
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
        System.out.println(currentLocale.getDisplayName() + ", " + currentCurrency.getDisplayName() + ": "
                + currencyFormatter.format(currencyAmount));
    }

    static public void displayPercent(Locale currentLocale)
    {
        Double percent = new Double(0.75);
        NumberFormat percentFormatter;
        String percentOut;

        percentFormatter = NumberFormat.getPercentInstance(currentLocale);
        percentOut = percentFormatter.format(percent);
        System.out.println(percentOut + "   " + currentLocale.toString());
    }

    /**
     * Return a locale-specific instance of NumberFormat,
     * The format method accepts the Double as an argument and returns
     * the formatted number in a String.
     */
    @Test
    public void testGetNumberInstance()
    {
        Integer quantity = new Integer(123456);
        Double amount = new Double(345987.246);

        // France
        assertEquals("fr_FR", fr.toString());
        NumberFormat format = NumberFormat.getNumberInstance(fr);

        String quantityOut = format.format(quantity);
        String amountOUt = format.format(amount);
        assertEquals("123 456", quantityOut);
        assertEquals("345 987,246", amountOUt);

        // Germany
        assertEquals("de_DE", de.toString());
        format = NumberFormat.getNumberInstance(de);

        quantityOut = format.format(quantity);
        amountOUt = format.format(amount);
        assertEquals("123.456", quantityOut);
        assertEquals("345.987,246", amountOUt);

        // US
        assertEquals("en_US", us.toString());
        format = NumberFormat.getNumberInstance(us);

        quantityOut = format.format(quantity);
        amountOUt = format.format(amount);
        assertEquals("123,456", quantityOut);
        assertEquals("345,987.246", amountOUt);
    }
}
