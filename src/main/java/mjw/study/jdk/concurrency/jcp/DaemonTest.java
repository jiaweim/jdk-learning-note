package mjw.study.jdk.concurrency.jcp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 24 Oct 2019, 1:04 PM
 */
public class DaemonTest
{
    @Test
    void testDaemon()
    {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
//        thread.setDaemon(true);
        thread.start();
        assertFalse(thread.isDaemon());
    }

    @Test
    void testSetDaemon()
    {
        Thread thread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            while (true) {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ": New Thread is running..." + i);
                    try {
                        //Wait for one sec so it doesn't print too fast
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // prevent the Thread to run forever. It will finish it's execution after 2 seconds
                if (System.currentTimeMillis() - startTime > 2000) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        thread.start();
        assertThrows(IllegalThreadStateException.class, () -> thread.setDaemon(true));
    }

    public static void main(String[] args) throws InterruptedException
    {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
//        thread.setDaemon(true);
        thread.start();
        Thread.sleep(2000L);
        System.out.println("finish");
    }
}
