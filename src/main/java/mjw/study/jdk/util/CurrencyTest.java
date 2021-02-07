package mjw.study.jdk.util;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 15 May 2019, 9:31 PM
 */
class CurrencyTest
{
    @Test
    void test()
    {
        double pay = 12324.13;
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(formatter.format(pay));
        Locale locale = new Locale("en", "IN");
        formatter = NumberFormat.getCurrencyInstance(locale);
        System.out.println(formatter.format(pay));
        formatter = NumberFormat.getCurrencyInstance(Locale.CHINA);
        System.out.println(formatter.format(pay));
        formatter = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println(formatter.format(pay));

        for (Currency availableCurrency : Currency.getAvailableCurrencies()) {
            System.out.println(availableCurrency + "\t" + availableCurrency.getCurrencyCode() + "\t" + availableCurrency.getDisplayName());
        }

    }

    @Test
    void create()
    {
        Locale locale = new Locale("inc", "IN");
    }
}
