package mjw.study.jdk.lang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.10.15, 9:37 AM
 */
class DoubleToFloat
{
    @Test
    void test()
    {
        double d = 520.85944;
        float f = (float) d;
        System.out.println(f);
    }

    @Test
    void testCompare()
    {
        Double a = Double.NaN;
        Double b = Double.NaN;
        Double c = 0.;
        Double d = 1.;

        assertEquals(a, b);

        System.out.println(Double.compare(a, c));
        System.out.println(Double.compare(c, a));
        System.out.println(Double.compare(c, d));
    }
}
