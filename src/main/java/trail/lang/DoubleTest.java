package trail.lang;

import org.junit.jupiter.api.Test;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 26 Oct 2018, 10:47 AM
 */
class DoubleTest
{
    @Test
    void testCompare()
    {
        Double a = 1.;
        Double b = Double.NaN;
        int compare = Double.compare(a, b);
        System.out.println(compare);
    }
}
