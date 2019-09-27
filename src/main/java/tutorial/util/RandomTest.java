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

import java.util.Random;

import static org.testng.Assert.assertEquals;

/**
 *
 * @author JiaweiM
 * @date Sep 18, 2015 8:46:12 AM
 */
public class RandomTest
{

    @Test
    public void testStream()
    {
        int[] luckArray = new Random().ints(1, 59).distinct().limit(6).toArray();
        assertEquals(6, luckArray.length);
    }

}
