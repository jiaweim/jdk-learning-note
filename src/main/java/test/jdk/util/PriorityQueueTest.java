/*
 * Copyright 2017 JiaweiMao jiaweiM_philo@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package test.jdk.util;


import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date Jul 18 2016, 16:55
 */
public class PriorityQueueTest {

    @Test
    public void testConstr() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(5);
        assertEquals(0, queue.size());
    }

    /**
     * Add和offer功能完全相同，add直接调用offer
     */
    @Test
    public void testAdd() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(10);
        for (int i = 10; i > 0; i--) {
            queue.add(i);
        }
        assertEquals(10, queue.size());
        int[] values = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int i = 0;
        while (queue.size() != 0) {
            assertEquals(queue.poll().intValue(), values[i]);
            i++;
        }
    }

    @Test
    public void testComparator2() {

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
    public void testComparator() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(5);
        for (int i = 10; i > 0; i--) {
            pq.offer(i);
        }

        int[] exp = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
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

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

    }
}
