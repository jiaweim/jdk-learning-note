package trail.util;


import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.10.13, 7:57 PM
 */
class HashSetTest
{
    @Test
    void equals()
    {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(1);

        assertEquals(set1, set2);

    }

}
