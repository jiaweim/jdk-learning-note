package mjw.study.jdk.util;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author JiaweiM
 * @date Sep 18, 2015 2:04:31 PM
 */
class ObjectsTest
{
    @Test
    void testEqual() throws Exception
    {
        assertTrue(Objects.equals(1, 1));
        assertTrue(Objects.equals(null, null));

        String s1 = "foobar";
        String s2 = new String(s1);

        assertTrue(Objects.equals(s1, s2));
        assertFalse(Objects.equals(s1, null));
        assertFalse(Objects.equals(null, s1));
        assertFalse(Objects.equals("foo", "bar"));
        assertFalse(Objects.equals("1", 1));
    }

    @Test
    public void testHashCode() throws Exception
    {
        int h1 = Objects.hash(1, "two", 3.0);
        int h2 = Objects.hash(new Integer(1), new String("two"), new Double(3.0));
        // repeatable
        assertEquals(h1, h2);

        // These don't strictly need to be true, but they're nice properties.
        assertTrue(Objects.hash(1, 2, null) != Objects.hash(1, 2));
        assertTrue(Objects.hash(1, 2, null) != Objects.hash(1, null, 2));
        assertTrue(Objects.hash(1, null, 2) != Objects.hash(1, 2));
        assertTrue(Objects.hash(1, 2, 3) != Objects.hash(3, 2, 1));
        assertTrue(Objects.hash(1, 2, 3) != Objects.hash(2, 3, 1));
    }

}
