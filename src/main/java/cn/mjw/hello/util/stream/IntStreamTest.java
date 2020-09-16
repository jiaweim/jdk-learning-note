package cn.mjw.hello.util.stream;

import org.junit.jupiter.api.Test;

import java.util.OptionalInt;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 18 Nov 2019, 3:08 PM
 */
public class IntStreamTest
{
    @Test
    void testRange()
    {
        OptionalInt reduce = IntStream.range(1, 4).reduce(Integer::sum);
        assertEquals(reduce.getAsInt(), 6);

        int reduced = IntStream.range(1, 4).reduce(10, (left, right) -> left + right);
        assertEquals(reduced, 16);
    }
}
