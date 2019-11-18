package trail.concurrency;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 01 Nov 2019, 4:04 PM
 */
public class SafeTask implements Runnable
{
    private static ThreadLocal<Date> startDate = ThreadLocal.withInitial(Date::new);

    @Override
    public void run()
    {
        System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate.get());

        try {
            TimeUnit.SECONDS.sleep((long) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate.get());
    }

    public static void main(String[] args)
    {
        SafeTask task = new SafeTask();
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
