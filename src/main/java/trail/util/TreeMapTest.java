package trail.util;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date Jul 18 2016, 16:02
 */
class TreeMapTest
{

    @Test
    void test()
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
    void testHigherEntry()
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
