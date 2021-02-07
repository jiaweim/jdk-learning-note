package mjw.study.jdk.lang.reflect;


import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.11, 4:02 PM
 */
class ArrayTest
{
    @Test
    void testArrayGet()
    {
        int[] array = new int[]{1, 3, 5, 7, 9, 11};
        int i = 0;
        Object value = Array.get(array, i);
        assertEquals(value, 1);
    }

    @Test
    void testBooleanArray()
    {
        boolean[] value = new boolean[3];
        for (int i = 0; i < value.length; i++) {
            System.out.println(value[i]);
        }
    }

}
