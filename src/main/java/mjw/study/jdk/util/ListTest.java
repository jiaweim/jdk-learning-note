package mjw.study.jdk.util;

import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author JiaweiMao
 * @version 1.00
 * @date Jul 07 2016, 18:58
 */
class ListTest
{
    @Test
    void testIt()
    {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        ListIterator<Integer> it = list.listIterator(list.size());
        Integer item = it.previous();
        assertEquals(item.intValue(), 4);
        assertEquals(it.nextIndex(), 3);
    }

    @Test
    void testToStringEmpty()
    {
        List<Integer> list = new ArrayList<>();
        System.out.println(list);
    }

    @Test
    void modifyAfterAdd()
    {

        AObj obj = new AObj();
        List<AObj> list = new ArrayList<>();
        list.add(obj);

        obj.setValue(2);

        AObj obj1 = list.get(0);
        System.out.println(obj1.getValue());

    }

    @Test
    void equals()
    {

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(1);
        list2.add(3);
        list2.add(2);

        assertFalse(list1.equals(list2));

        Collections.sort(list1);
        Collections.sort(list2);

        assertTrue(list1.equals(list2));
    }

    @Test
    void toMap()
    {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(5);
        list.add(5);
        list.add(6);
        list.add(7);

        Collections.sort(list);

        Int2IntOpenHashMap map = new Int2IntOpenHashMap();

        int previousValue = list.get(0);
        int previousId = 0;
        int count = 0;
        for (int id = 0; id < list.size(); id++) {
            int value = list.get(id);
            if (value != previousValue) {
                count = id - previousId;
                map.addTo(count, 1);
                previousId = id;
                previousValue = value;
            }
        }
        count = list.size() - previousId;
        map.addTo(count, 1);

        System.out.println(map);

    }

    @Test
    void testSet()
    {
        List<Integer> values = new ArrayList<>();
        values.add(3);
        values.add(6);
        values.add(5);
        values.add(2);

        values.set(2, 4);
        System.out.println(values);
    }

    @Test
    void testSetup()
    {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        list.set(1, 4);
        System.out.println(list);
        list.set(0, 4);
        System.out.println(list);
    }

    @Test
    void modify()
    {
        List<ObjectWrapper> list = new ArrayList<>();
        list.add(new ObjectWrapper());
        list.add(new ObjectWrapper());
        list.add(new ObjectWrapper());
        list.add(new ObjectWrapper());

        for (int i = 0; i < list.size(); i++) {
            ObjectWrapper oWrapper = list.get(i);
            oWrapper.addValue(2, 2.0);
        }

    }

    @Test
    void testSort()
    {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.sort((x, y) -> Integer.compare(y, x));
        assertArrayEquals(new Integer[]{5, 4, 3, 2, 1}, list.toArray());

        long count = list.stream().filter(value -> (value & 2) == 0).count();
        assertEquals(3, count);
    }

    @Test
    void test2()
    {
        List<String> names = new ArrayList<>();
        names.add("Taobao");
        names.add("Jingdong");
        List<String> lowerNames = names.stream().map(name -> name.toLowerCase()).collect(Collectors.toList());
    }

    @Test
    void testAdd()
    {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1, 5);

        assertEquals(list, Arrays.asList(1, 5, 2, 3));
    }

    private static class AObj
    {
        private int value = 0;

        public AObj()
        {
            this.value = 0;
        }

        public int getValue()
        {
            return this.value;
        }

        public void setValue(int value)
        {
            this.value = value;
        }
    }
}
