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

import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


/**
 * @author JiaweiMao
 * @version 1.00
 * @date Jul 04 2016, 10:09
 */
class MapTest {


    private static void removeNegative(Map<Integer, Integer> map){
        map.entrySet().removeIf(entry -> entry.getValue() < 0);
    }

    @Test
    void testReference(){

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, -1);
        map.put(3, -2);
        map.put(4, 3);

        System.out.println(map);
        removeNegative(map);
        System.out.println(map);
    }


    @Test
    void computeIfAbsent(){

        Map<String, Boolean> map = new ConcurrentHashMap<>();
        map.computeIfAbsent("snop", new Function<String, Boolean>() {
            @Override
            public Boolean apply(String s) {
                return f(s);
            }
        });

    }

    static boolean f(String s) {
        System.out.println("creating a value for \""+s+'"');
        return s.isEmpty();
    }

    @Test
    void equals() {

        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 2);
        map1.put(2, 1);
        map1.put(3, 3);

        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(2, 1);
        map2.put(3, 3);
        map2.put(1, 2);

        assertEquals(map1, map2);

        map2.put(2, 2);
        assertNotEquals(map1, map2);

    }

    @Test
    public void TIntMapEquals(){

        Int2IntOpenHashMap map1 = new Int2IntOpenHashMap();
        map1.put(1, 2);
        map1.put(2, 1);
        map1.put(3, 3);

        Int2IntOpenHashMap map2 = new Int2IntOpenHashMap();
        map2.put(2, 1);
        map2.put(3, 3);
        map2.put(1, 2);

        assertEquals(map1, map2);
        map2.put(2, 2);
        assertNotEquals(map1, map2);

    }

    @Test
    public void testMerge() {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        Map<Integer, Integer> value1 = new HashMap<>();
        value1.put(1, 6);
        value1.put(2, 7);
        value1.put(3, 8);
        value1.put(4, 9);
        value1.put(5, 10);
        map.put(9, value1);

        map.get(9).merge(1, 2, (x, y) -> x + y);
        assertEquals(8, map.get(9).get(1).intValue());

        map.get(9).merge(6, 1, (x, y) -> x + y);
        assertEquals(1, map.get(9).get(6).intValue());
    }

    @Test
    public void testMerge2() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 6);
        map.put(3, 7);
        map.put(4, 3);
        map.put(5, 34);
        map.put(6, 56);

        map.merge(1, 8, (x, y) -> y / x);
        assertEquals(4, map.get(1).intValue());
    }


    @Test
    public void testMap() {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        Map<Integer, Integer> value = map.get(1);
        if (value == null) {
            value = new HashMap<>();
            map.put(1, value);
        }

        value.put(1, 6);
        value.put(2, 7);
        value.put(3, 8);
        value.put(4, 9);
        value.put(5, 10);

        System.out.println(map.get(1).size());
    }

    @Test
    public void testforEach() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 2);
        map.put(3, 2);
        map.put(4, 2);

        map.forEach((x, y) -> {
            if (x == 1) {
                assertEquals(2, y.intValue());
            }
        });
    }

    @Test
    public void testPutIfAbsent() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 3);
        map.put(3, 4);
        map.put(4, 5);

        map.putIfAbsent(1, 4);
        assertEquals(2, map.get(1).intValue());
    }
}
