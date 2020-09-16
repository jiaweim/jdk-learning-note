package cn.mjw.hello.concurrency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 04 Mar 2020, 9:00 PM
 */
public class ThreadGroupTest
{
    @Test
    void testCreate()
    {
        ThreadGroup g1 = new ThreadGroup("Parent ThreadGroup");

        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());

        Thread t1 = new Thread(g1, runnable, "one");
        t1.start();
        Thread t2 = new Thread(g1, runnable, "two");
        t2.start();
        Thread t3 = new Thread(g1, runnable, "three");
        t3.start();

        assertEquals(g1.getName(), "Parent ThreadGroup");

        g1.list();
    }

    @Test
    void testAccess()
    {
        ThreadGroup g1 = new ThreadGroup("Parent");
        ThreadGroup g2 = new ThreadGroup(g1, "Child");

        Thread t1 = new NewThread(g1, "Thread 1");
        t1.start();
        Thread t2 = new NewThread(g1, "Thread 2");
        t2.start();

        g1.checkAccess();
        System.out.println(g1.getName() + " has access");
        g2.checkAccess();
        System.out.println(g2.getName() + " has access");
    }

    static class NewThread extends Thread
    {
        public NewThread(ThreadGroup group, String name)
        {
            super(group, name);
        }

        @Override
        public void run()
        {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " interrupted");
                }
            }
            System.out.println(Thread.currentThread().getName() + " completed");
        }
    }

}
