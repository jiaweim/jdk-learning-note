package cn.mjw.hello.util;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author JiaweiM
 * @date Aug 13, 2015 10:55:48 AM
 */
class CollectionsTest
{
    @Test
    void testUnmodifiableSet()
    {
        Set<String> set = new HashSet<String>();
        set.add("Welcome");
        set.add("to");
        set.add("tp");

        Set<String> unmodSet = Collections.unmodifiableSet(set);
        // modified operation is not supported on unmodifiableSet
        unmodSet.add("Hello");
    }
}
