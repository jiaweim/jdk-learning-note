package trail.concurrency;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 01 Nov 2019, 3:59 PM
 */
public class UnsafeTask implements Runnable
{
    private Date startDate;

    @Override
    public void run()
    {
        startDate = new Date();
        System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate);
        try {
            TimeUnit.SECONDS.sleep((long) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate);
    }

    public static void main(String[] args)
    {
        UnsafeTask task = new UnsafeTask();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(task);
            thread.start();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
