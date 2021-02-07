package mjw.study.jdk.concurrency.jcp;

import java.util.concurrent.TimeUnit;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 23 Oct 2019, 10:59 PM
 */
public class TerminatedTest
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        TimeUnit.SECONDS.sleep(2);
        thread.start();
    }
}
