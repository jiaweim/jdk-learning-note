package cn.mjw.hello.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 05 Mar 2020, 10:43 AM
 */
public class InterruptingThread2 implements Runnable
{
    @Override
    public void run()
    {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Exception ignored: " + e);
        }
    }

    public static void main(String[] args)
    {
        Thread t = new Thread(new InterruptingThread2());
        t.start();
        t.interrupt();
    }
}
