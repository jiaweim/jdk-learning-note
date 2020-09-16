package cn.mjw.hello.util;


import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date Jul 18 2016, 16:55
 */
class PriorityQueueTest
{
    /**
     * the order is not guaranteed.
     */
    @Test
    void testFor()
    {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(5);
        queue.offer(1);
        queue.offer(2);
        for (Integer integer : queue) {
            System.out.println(integer);
        }

        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    void testConstr()
    {
        PriorityQueue<Integer> queue = new PriorityQueue<>(5);
        assertEquals(0, queue.size());
    }

    @Test
    void testPoll()
    {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(3);
        queue.offer(2);
        queue.offer(1);
        assertEquals(queue.poll().intValue(), 1);
    }

    /**
     * Add和offer功能完全相同，add直接调用offer
     */
    @Test
    void testAdd()
    {
        PriorityQueue<Integer> queue = new PriorityQueue<>(10);
        for (int i = 10; i > 0; i--) {
            queue.add(i);
        }
        assertEquals(10, queue.size());
        int[] values = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i = 0;
        while (queue.size() != 0) {
            assertEquals(queue.poll().intValue(), values[i]);
            i++;
        }
    }

    @Test
    void testComparator2()
    {
        PriorityQueue<String> queue = new PriorityQueue<>(10, (x, y) -> {
            if (x.length() < y.length()) {
                return -1;
            }
            if (x.length() > y.length()) {
                return 1;
            }
            return 0;
        });

        queue.add("short");
        queue.add("very long indeed");
        queue.add("medium");

        while (queue.size() != 0) {
            System.out.println(queue.remove());
        }

    }

    @Test
    void testComparator()
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(5);
        for (int i = 10; i > 0; i--) {
            pq.offer(i);
        }

        int[] exp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i = 0;
        while (i < 10) {
            assertEquals(pq.poll().intValue(), exp[i]);
            i++;
        }

        pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

        pq.add(1);
        pq.add(2);
        pq.add(4);
        pq.add(3);
        pq.add(5);

        assertEquals(pq.poll().intValue(), 5);
        assertEquals(pq.poll().intValue(), 4);
        assertEquals(pq.poll().intValue(), 3);
        assertEquals(pq.poll().intValue(), 2);
    }
}
