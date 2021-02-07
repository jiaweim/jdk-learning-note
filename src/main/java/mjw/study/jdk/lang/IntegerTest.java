package mjw.study.jdk.lang;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author JiaweiMao 2017.03.27
 * @since 1.0-SNAPSHOT
 */
class IntegerTest
{
    @Test
    void testCompare()
    {
        Integer a = null;
        Integer b = 0;
        assertThrows(NullPointerException.class, () -> Integer.compare(a, b));
    }

    @Test
    void testToBinaryString()
    {
        String s = Integer.toBinaryString(-5);
        System.out.println(s);
    }

    @Test
    void testCast()
    {
        System.out.println(((int) (0.4 * 2)));
        System.out.println(((int) (0.5 * 2)));
        System.out.println(((int) (0.6 * 2)));
    }

    @Test
    public void testEquals()
    {
        System.out.println(100 == 100);
        System.out.println(1000 == 1000);
    }

    @Test
    void maxValue()
    {
        assertEquals(2147483647, Integer.MAX_VALUE);
    }

}
