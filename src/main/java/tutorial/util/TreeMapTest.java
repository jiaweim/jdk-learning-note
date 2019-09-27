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

import java.util.Map;
import java.util.TreeMap;

import static org.testng.Assert.assertEquals;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date Jul 18 2016, 16:02
 */
public class TreeMapTest
{

    @Test
    public void test()
    {
        TreeMap<String, Integer> map = new TreeMap<>((o1, o2) -> Integer.compare(o1.length(), o2.length()));

        map.put("*", 1);
        map.put("**", 2);
        map.put("*******", 7);
        map.put("***", 3);
        map.put("*****", 5);
        map.put("****", 4);
        map.put("******", 6);
        Map.Entry<String, Integer> entry1 = map.pollFirstEntry();
        System.out.println(entry1.getKey());
        Map.Entry<String, Integer> entry2 = map.pollFirstEntry();
        System.out.println(entry2.getKey());
    }

    @Test
    public void testHigherEntry()
    {
        // creating tree map
        TreeMap<Integer, String> treemap = new TreeMap<>();

        // populating tree map
        treemap.put(2, "two");
        treemap.put(1, "one");
        treemap.put(3, "three");
        treemap.put(6, "six");
        treemap.put(5, "five");

        assertEquals(treemap.higherEntry(0).getValue(), "one");
        assertEquals(treemap.higherEntry(3).getValue(), "five");
    }
}
