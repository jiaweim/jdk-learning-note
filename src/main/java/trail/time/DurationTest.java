package trail.time;

import org.junit.jupiter.api.Test;

import java.time.Duration;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.10.03, 10:58 PM
 */
class DurationTest
{
    @Test
    void parse()
    {
        String s = "PT1597.46S";
        Duration duration = Duration.parse(s);
        System.out.println(duration.getSeconds());
    }
}
