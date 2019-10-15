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

/**
 * @version 1.00
 */

package tutorial.util;

import org.testng.annotations.Test;

import java.util.ArrayDeque;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @author JiaweiM
 * @date Jul 24, 2015 3:43:27 PM
 */
public class ArrayDequeTest {

    @Test
    public void testAdd() {
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
