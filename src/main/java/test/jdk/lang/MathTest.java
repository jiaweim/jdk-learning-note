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
package test.jdk.lang;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author JiaweiMao
 * @version 1.00
 * @date Jun 14 2016, 20:40
 */
class MathTest {

    @Test
    void computeIfAbsent() {


    }

    private static Map<Integer, Long> memo = new HashMap<>();

    static {
        memo.put(0, 0L); //fibonacci(0)
        memo.put(1, 1L); //fibonacci(1)
    }

    public static long fibonacci(int x) {
        return memo.computeIfAbsent(x, n -> fibonacci(n - 2) + fibonacci(n - 1));
    }

    /**
     * 指数运算
     */
    @Test
    void testPow() {

        double value = Math.pow(5, 2);
        assertEquals(25.0, value, 0.0001);
    }

    /**
     * 浮点数最接近的整数:
     * 如果到两个整数的距离相同，取偶数
     */
    @Test
    void testRint() {
        double value = Math.rint(0.3);
        assertEquals(0.0, value, 0.001);

        value = Math.rint(0.5);
        assertEquals(0.0, value, 0.001);

        value = Math.rint(1.5);
        assertEquals(2.0, value, 0.001);
    }

    @Test
    void test() {
        double p = 1.48E12;

        System.out.println(Math.log10(p));
    }

    @Test
    public void testRandom() {
        double r = Math.random();
        assertTrue(r >= 0);
        assertTrue(r < 1);
    }

    @Test
    public void testCeil() {
        double ceil = Math.ceil(12.01);
        assertEquals(13.0, ceil, 0.0);
        ceil = Math.ceil(12.99);
        assertEquals(13.0, ceil, 0.0);
    }
}
