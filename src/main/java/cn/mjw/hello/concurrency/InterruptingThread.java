package cn.mjw.hello.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 05 Mar 2020, 10:34 AM
 */
public class InterruptingThread implements Runnable
{
    @Override
    public void run()
    {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread interrupted: " + e);
        }
    }

    public static void main(String[] args)
    {
        Thread t1 = new Thread(new InterruptingThread());
        t1.start();
        try {
            t1.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
