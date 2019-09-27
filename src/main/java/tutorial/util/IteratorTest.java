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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.11.10, 4:18 PM
 */
public class IteratorTest
{

    @Test
    public void test()
    {

        List<Integer> list = Arrays.asList(1, 2, 3);

        Iterator<Integer> iterator = list.iterator();
        int id = 0;
        System.out.println(id + ":" + iterator.next());

        while (iterator.hasNext()) {
            id++;
            System.out.println(id + ":" + iterator.next());
        }

    }


    @Test
    public void testRemove()
    {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            list.add(i);
        }

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int value = it.next();
            if (value % 2 == 0) {
                it.remove();
            }
        }

        System.out.println(list);
    }
}
