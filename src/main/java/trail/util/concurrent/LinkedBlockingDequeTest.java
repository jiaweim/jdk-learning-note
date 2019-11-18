package trail.util.concurrent;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiMao
 * @date Mar 12, 2016 4:32:15 PM
 */
class LinkedBlockingDequeTest
{

    @Test
    void testdrainTo()
    {
        LinkedBlockingDeque<Integer> deque = new LinkedBlockingDeque<Integer>();
        deque.add(2);
        deque.add(2);
        deque.add(2);
        deque.add(2);
        deque.add(2);
        assertEquals(5, deque.size());

        ArrayList<Integer> list = new ArrayList<Integer>();
        deque.drainTo(list);
        assertEquals(0, deque.size());
        assertEquals(5, list.size());
    }
}
