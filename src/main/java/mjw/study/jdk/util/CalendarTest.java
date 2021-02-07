package mjw.study.jdk.util;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 15 May 2019, 9:02 PM
 */
public class CalendarTest
{
    @Test
    void testInstant()
    {
        Instant min = Instant.MIN; //  billion  years ago
        System.out.println(min);
        Instant start = Instant.now();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
        }
        Instant end = Instant.now();
        Duration timeSlapsed = Duration.between(start, end);
        long millis = timeSlapsed.toMillis();
        System.out.println(millis);
    }

    @Test
    void testLocalDate()
    {
        LocalDate localDate = LocalDate.of(2015, 8, 5);
        String s = localDate.getDayOfWeek().toString();
        System.out.println(s);
    }
}
