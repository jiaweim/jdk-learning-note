package cn.mjw.hello.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author JiaweiM
 * @date Jul 24, 2015 3:43:27 PM
 */
class ArrayDequeTest
{
    @Test
    void testAdd()
    {
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(1);
        deque.add(2);
        deque.add(3);

        assertEquals(1, deque.poll().intValue());
        assertEquals(2, deque.poll().intValue());
        assertEquals(3, deque.poll().intValue());
        assertEquals(1, deque.poll().intValue());
        assertEquals(2, deque.poll().intValue());
        assertEquals(3, deque.poll().intValue());
        assertTrue(deque.isEmpty());
    }

}
