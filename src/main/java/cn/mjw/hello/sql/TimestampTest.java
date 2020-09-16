package cn.mjw.hello.sql;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 15 Oct 2019, 12:37 PM
 */
class TimestampTest
{
    @Test
    void testCtr()
    {
        // system time
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);

        // Date
        Timestamp timestamp1 = new Timestamp(new Date().getTime());
        System.out.println(timestamp1);
    }

    @Test
    void testInstant()
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Instant instant = timestamp.toInstant();
        System.out.println(instant);

        Timestamp from = Timestamp.from(instant);
        System.out.println(from);
    }
}
