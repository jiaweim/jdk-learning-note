package cn.mjw.hello.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author JiaweiMao
 * @version 1.00
 * @date Jun 08 2016, 14:57
 */
class ArraysTest
{
    @Test
    void binarySearch()
    {
        int[] arrays = {1, 3, 5, 7, 9};
        int val = 4;
        int i = Arrays.binarySearch(arrays, val);
        System.out.println(0 - (i + 1));

    }

    @Test
    void doublearr()
    {
        double[] value = new double[3];
        System.out.println(value[0]);
    }

    @Test
    void testfillChar()
    {
        char[] carray = new char[3];
        Arrays.fill(carray, 'e');
        assertEquals(3, carray.length);
        assertTrue(carray[0] == 'e');
        assertTrue(carray[2] == 'e');
    }

    /**
     * Collections.reverseOrder() sort according the compareTo method.
     */
    @Test
    void testSort()
    {
        ToBeSort s1 = new ToBeSort(1);
        ToBeSort s2 = new ToBeSort(3);
        ToBeSort s3 = new ToBeSort(2);
        ToBeSort s4 = new ToBeSort(5);

        List<ToBeSort> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        Collections.sort(list);
        assertEquals(5, list.get(0).getValue());
        assertEquals(3, list.get(1).getValue());
        assertEquals(2, list.get(2).getValue());
        assertEquals(1, list.get(3).getValue());

        Collections.sort(list, Collections.reverseOrder());
        assertEquals(1, list.get(0).getValue());
        assertEquals(2, list.get(1).getValue());
        assertEquals(3, list.get(2).getValue());
        assertEquals(5, list.get(3).getValue());
    }


    class ToBeSort implements Comparable<ToBeSort>
    {
        private int value;

        ToBeSort(int value)
        {
            this.value = value;
        }

        int getValue()
        {
            return value;
        }

        @Override
        public int compareTo(ToBeSort o)
        {
            return Integer.compare(o.value, value);
        }
    }
}
