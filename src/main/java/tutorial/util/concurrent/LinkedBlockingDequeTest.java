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
package tutorial.util.concurrent;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;

import static org.testng.Assert.assertEquals;


/**
 * @author JiaweiMao
 * @date Mar 12, 2016 4:32:15 PM
 */
public class LinkedBlockingDequeTest
{

    @Test
    public void testdrainTo()
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
