package mjw.study.jdk.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 05 Mar 2020, 7:29 PM
 */
public class SynchronizedYN
{
    public synchronized void m1()
    {
        System.out.println(Thread.currentThread().getName() + " m1 start...");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end");
    }

    public void m2()
    {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 ");
    }

    public static void main(String[] args)
    {
        SynchronizedYN yn = new SynchronizedYN();

        new Thread(yn::m1, "t1").start();
        new Thread(yn::m2, "t2").start();
    }
}
