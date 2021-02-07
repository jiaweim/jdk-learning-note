package mjw.study.jdk.lang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 09 Jan 2019, 2:24 PM
 */
class ByteTest
{
    @Test
    public void testEquals()
    {
        byte a = 1;
        byte b = 1;

        assertTrue(a == b);
        byte c = 2;
        assertFalse(a != b);
    }
}
