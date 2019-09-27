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
package tutorial.util;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;


public class ComparatorTest
{
    @Test
    public void testCtrLambda()
    {
        int limit = 2;
        PriorityQueue<String> queue = new PriorityQueue<>(5, Comparator.comparingInt(String::length));
        String[] values = new String[]{"ab", "a", "abc", "daged", "agdahg"};
        for (String value : values) {
            queue.add(value);
            if (queue.size() > limit)
                System.out.println(queue.poll());
        }

        System.out.println();
        System.out.println("raming");
        for (String value : queue) {
            System.out.println(value);
        }

    }

    @Test
    public void testChain()
    {
        List<ToOrder> orders = new ArrayList<>();
        orders.add(new ToOrder(null, "1", 2.0));
        orders.add(new ToOrder(1, "3", 3.0));
        orders.add(new ToOrder(2, "5", 5.0));
        orders.add(new ToOrder(4, "2", 1.0));
        orders.add(new ToOrder(2, "8", null));
        orders.add(new ToOrder(2, "8", 1.));
        orders.add(new ToOrder(2, "8", 2.));

        orders.sort(Comparator.comparing(ToOrder::getV1, Comparator.nullsLast(Comparator.naturalOrder()))
                .thenComparing(ToOrder::getV2, (Comparator<String>) Comparator.naturalOrder().reversed())
                .thenComparing(ToOrder::getV3, Comparator.nullsFirst(Comparator.naturalOrder())));
        for (ToOrder toOrder : orders) {
            System.out.println(toOrder);
        }
    }

}
