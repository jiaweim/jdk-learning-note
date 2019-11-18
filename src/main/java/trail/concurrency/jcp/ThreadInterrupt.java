package trail.concurrency.jcp;

import java.util.concurrent.TimeUnit;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 24 Oct 2019, 2:38 PM
 */
public class ThreadInterrupt
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Be interrupted.");
            }
        });
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2); // short break to make sure thread is started.
        thread.interrupt();
    }
}
