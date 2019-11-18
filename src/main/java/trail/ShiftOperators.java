package trail;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiMao
 * @version 1.00
 * @date Jun 14 2016, 8:53
 */
class ShiftOperators
{
    @Test
    void left()
    {
        int x = 3;
        int y = x << 1;
        assertEquals(6, y);
    }

    @Test
    void right()
    {
        int x = 4;
        int y = x >> 1;
        assertEquals(2, y);
    }
}
