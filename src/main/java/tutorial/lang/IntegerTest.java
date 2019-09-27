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

package tutorial.lang;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

/**
 * @author JiaweiMao 2017.03.27
 * @since 1.0-SNAPSHOT
 */
public class IntegerTest {

    @Test
    public void testCompare() {
        Integer a = null;
        Integer b = 0;
        assertThrows(NullPointerException.class, () -> Integer.compare(a, b));
    }

    @Test
    public void testToBinaryString() {
        String s = Integer.toBinaryString(-5);
        System.out.println(s);
    }

    @Test
    public void testCast() {
        System.out.println(((int) (0.4 * 2)));
        System.out.println(((int) (0.5 * 2)));
        System.out.println(((int) (0.6 * 2)));
    }

    @Test
    public void testEquals() {
        System.out.println(100 == 100);
        System.out.println(1000 == 1000);
    }

    @Test
    void maxValue() {
        assertEquals(2147483647, Integer.MAX_VALUE);
    }

}
