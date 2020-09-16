package cn.mjw.hello.concurrency.jcp;

import java.util.concurrent.TimeUnit;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 21 Oct 2019, 9:44 AM
 */
public class TryConcurrency
{
    public static void main(String[] args)
    {
        new Thread(TryConcurrency::enjoyMusic).start();
        browseNews();
    }

    private static void browseNews()
    {
        for (; ; ) {
            System.out.println("Uh-huh, the good news.");
            sleep(1);
        }
    }

    private static void enjoyMusic()
    {
        for (; ; ) {
            System.out.println("Uh-huh, the nice music.");
            sleep(1);
        }
    }

    /**
     * simulate the wait and ignore exception.
     *
     * @param seconds seconds
     */
    private static void sleep(int seconds)
    {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
