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

/**
 * @author JiaweiMao
 * @version 1.00
 * @date Jul 08 2016, 10:53
 */
public class ComparatorTest {

    @Test
    public void testCtrLambda() {
        int limit = 2;
        PriorityQueue<String> queue = new PriorityQueue<>(5, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        String[] values = new String[]{"ab", "a", "abc", "daged", "agdahg"};
        for(String value : values){
            queue.add(value);
            if(queue.size() > limit)
                System.out.println(queue.poll());
        }

        System.out.println();
        System.out.println("raming");
        for(String value : queue){
            System.out.println(value);
        }

    }

}
