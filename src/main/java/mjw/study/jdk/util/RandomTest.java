package mjw.study.jdk.util;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiM
 * @date Sep 18, 2015 8:46:12 AM
 */
public class RandomTest
{
    @Test
    public void testStream()
    {
        int[] luckArray = new Random().ints(1, 59).distinct().limit(6).toArray();
        assertEquals(6, luckArray.length);
    }

}
