package cn.mjw.hello.concurrency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 03 Mar 2020, 10:09 PM
 */
public class ThreadStateDemo
{
    @Test
    void testNew()
    {
        Thread t = new Thread(() -> { });
        assertSame(t.getState(), Thread.State.NEW);
    }

    @Test
    void testRunnable()
    {
        Thread t = new Thread(() -> {});
        t.start();
        assertSame(t.getState(), Thread.State.RUNNABLE);
    }

    @Test
    void testBlock()
    {
        Thread t1 = new Thread(new DemoThread());
        Thread t2 = new Thread(new DemoThread());

        t1.start();
        t2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertSame(Thread.State.BLOCKED, t2.getState());
        System.exit(0);
    }

    static class DemoThread implements Runnable
    {
        @Override
        public void run()
        {
            heavyTask();
        }

        public static synchronized void heavyTask()
        {
            while (true) {

            }
        }
    }

    @Test
    void testTimedWaiting()
    {
        Thread t1 = new Thread(new WaitThread());
        t1.start();

        // given enough time to start t1
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertSame(Thread.State.TIMED_WAITING, t1.getState());
    }

    class WaitThread implements Runnable
    {

        @Override
        public void run()
        {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void testTerminated()
    {
        Thread t1 = new Thread(() -> { });
        t1.start();
        try {
            // given enough time for t1 to complete
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertSame(Thread.State.TERMINATED, t1.getState());
    }
}
