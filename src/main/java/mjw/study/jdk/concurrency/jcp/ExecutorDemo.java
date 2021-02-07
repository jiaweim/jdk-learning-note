package mjw.study.jdk.concurrency.jcp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 24 Oct 2019, 4:30 PM
 */
public class ExecutorDemo
{
    public static void main(String[] args)
    {
        Runnable hello = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("Hello " + i);
            }
        };

        Runnable goodbyes = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("Goodbye " + i);
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(hello);
        executorService.execute(goodbyes);
    }
}
