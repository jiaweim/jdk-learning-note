package mjw.study.jdk.util;

import org.junit.jupiter.api.Test;

import java.util.IdentityHashMap;

class IdentityHashMapDemo
{
    private static final String A_STR = "First";
    private static final String B_STR = "Second";

    @Test
    void testSize()
    {
        IdentityHashMap<String, String> iMap = new IdentityHashMap<>();

    }

    @Test
    void testEquals()
    {
        // Create a hash map
        IdentityHashMap<String, Double> ihm = new IdentityHashMap<>();

        // Put elements to the map
        ihm.put(new String("Zara"), new Double(3434.34));
        ihm.put("Mahnaz", new Double(123.22));
        ihm.put("Ayan", new Double(1378.00));
        ihm.put("Daisy", new Double(99.22));
        ihm.put("Qadir", new Double(-19.08));
        ihm.put(new String("Zara"), 25.2);

        for (String key : ihm.keySet()) {
            System.out.println(key + "\t" + ihm.get(key));
        }
    }
}
