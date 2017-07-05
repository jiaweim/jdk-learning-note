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

package test.jdk.lang.reflect;


import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.11, 4:02 PM
 */
public class ArrayTest {

    @Test
    public void testArrayGet() {
        int[] array = new int[]{1, 3, 5, 7, 9, 11};
        int i=0;
        Object value = Array.get(array, i);
        assertEquals(value, 1);


    }

}
