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
package mjw.study.jdk;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiMao
 * @version 1.00
 * @date Jun 14 2016, 8:52
 */
class IncrementOperator
{
    /**
     * assign value first, increase then.
     */
    @Test
    void before()
    {
        int a = 10;
        assertEquals(10, a++);
        assertEquals(11, a++);
        assertEquals(12, a);

        int b = a++;
        assertEquals(12, b);
        assertEquals(13, a);
    }

    @Test
    void after()
    {
        int a = 10;
        int b = ++a;
        assertEquals(11, b);
    }

    @Test
    void testWhile()
    {
        int[] values = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2};
        int i = 0;
        assertEquals(10, values[i++]);
        assertEquals(9, values[i++]);
        int y = 0;
        int max = 10;
        while (y++ < max) {
            System.out.println(y);
        }
    }
}
