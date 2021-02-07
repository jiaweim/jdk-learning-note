package mjw.study.jdk.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.11.10, 4:18 PM
 */
public class IteratorTest
{
    @Test
    public void test()
    {
        List<Integer> list = Arrays.asList(1, 2, 3);

        Iterator<Integer> iterator = list.iterator();
        int id = 0;
        System.out.println(id + ":" + iterator.next());

        while (iterator.hasNext()) {
            id++;
            System.out.println(id + ":" + iterator.next());
        }

    }


    @Test
    public void testRemove()
    {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            list.add(i);
        }

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int value = it.next();
            if (value % 2 == 0) {
                it.remove();
            }
        }

        System.out.println(list);
    }
}
