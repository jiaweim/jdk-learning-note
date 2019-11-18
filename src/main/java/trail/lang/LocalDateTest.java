package trail.lang;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * A date without a time-zone
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2017.01.17, 3:41 PM
 */
class LocalDateTest
{
    @Test
    void ctr1()
    {
        // 获得当前日期
        LocalDate now = LocalDate.now();

        int year = now.getYear();
        System.out.println(year);

    }

}
