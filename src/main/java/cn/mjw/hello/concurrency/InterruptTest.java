package cn.mjw.hello.concurrency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 05 Mar 2020, 10:48 AM
 */
public class InterruptTest
{
    static class NoException implements Runnable
    {
        @Override
        public void run()
        {
            for (int i = 0; i <= 10; i++) {
                System.out.println(i);
            }
        }
    }

    @Test
    void test()
    {
        Thread t = new Thread(new NoException());
        t.start();
        t.interrupt();
        assertTrue(t.isInterrupted());
    }
}
