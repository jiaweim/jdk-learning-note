package tutorial.concurrency.jcp;

import java.util.concurrent.TimeUnit;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 24 Oct 2019, 2:45 PM
 */
public class ThreadInterrupted
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread thread = new Thread(() -> {
            while (true) {

            }
        });

        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());
        thread.interrupt();
        System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());
        System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());
    }
}
