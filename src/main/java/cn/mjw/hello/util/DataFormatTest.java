package cn.mjw.hello.util;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author JiaweiM
 * @Class DataFormatTest
 * @date Aug 13, 2015 10:56:48 AM
 */
public class DataFormatTest
{
    @Test
    public void testGetDateTimeInstance()
    {
        Date date = new Date();
        DateFormat df;
        df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.CHINA);
        System.out.println(df.format(date));
        df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.CHINESE);
        System.out.println(df.format(date));
    }
}
