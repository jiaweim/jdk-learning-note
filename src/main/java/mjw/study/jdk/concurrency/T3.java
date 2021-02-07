package mjw.study.jdk.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 05 Mar 2020, 9:49 PM
 */
public class T3
{
    volatile int count = 0;

    void m()
    {
        for (int i = 0; i < 10_000; i++)
            count++;
    }

    public static void main(String[] args)
    {
        T3 t = new T3();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threadList.add(new Thread(t::m, "thread-" + i));
        }
        threadList.forEach(Thread::start);

        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);
    }
}
