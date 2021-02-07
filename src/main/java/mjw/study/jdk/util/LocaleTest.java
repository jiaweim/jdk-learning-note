package mjw.study.jdk.util;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Locale用处有限，唯一有用的是那些标识语言和国家代码的方法，其中最重要的是Locale#getdisplayName，
 * 返回一个描述Locale的字符串。
 *
 * @author JiaweiM
 * @date Aug 13, 2015 11:22:50 AM
 */
class LocaleTest
{
    /**
     * Construct with language
     */
    @Test
    void testCtr()
    {
        Locale locale = new Locale("de");
        assertEquals("", locale.getCountry());
        assertEquals("de", locale.getLanguage());
    }


    /**
     * 返回本地操作系统的默认Locale, 可以调用setDefault 改变默认的Locale,这种
     * 改变只对当前程序有效，不影响系统。
     */
    @Test
    void testGetDefault()
    {
        Locale[] supportLocales = DateFormat.getAvailableLocales();
        for (int i = 0; i < supportLocales.length; i++) {
            Locale la = supportLocales[i];
//			System.out.println(la.getDisplayName());
        }
    }
}
