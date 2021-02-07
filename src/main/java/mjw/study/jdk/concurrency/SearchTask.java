package mjw.study.jdk.concurrency;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 01 Nov 2019, 4:41 PM
 */
public class SearchTask implements Runnable
{
    private Result result;

    public SearchTask(Result result)
    {
        this.result = result;
    }

    @Override
    public void run()
    {
        String name = Thread.currentThread().getName();
        System.out.printf("Thread %s: Start\n", name);

        try {
            doTask();
            result.setName(name);
        } catch (InterruptedException e) {
            System.out.printf("Thread %s: Interrupted\n", name);
            return;
        }
        System.out.printf("Thread %s: End\n", name);
    }

    private void doTask() throws InterruptedException
    {
        Random random = new Random((new Date()).getTime());
        int value = (int) (random.nextDouble() * 100);
        System.out.printf("Thread %s: %d\n", Thread.currentThread().getName(), value);
        TimeUnit.SECONDS.sleep(value);
    }

    public static void main(String[] args)
    {
        ThreadGroup group = new ThreadGroup("Searcher");
        Result result = new Result();
        SearchTask task = new SearchTask(result);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(group, task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Number of Threads: %d\n", group.activeCount()); // 获得线程组包含的线程数目
        System.out.println("Information about the ThreadGroup");
        group.list(); // 输出 group 里线程的信息

        Thread[] threads = new Thread[group.activeCount()];
        group.enumerate(threads);
        for (int i = 0; i < threads.length; i++) {
            System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
        }
        waitFinish(group); // 等待一个线程执行结束
        group.interrupt();

    }

    /**
     * 等待第一个线程执行结束
     */
    private static void waitFinish(ThreadGroup group)
    {
        while (group.activeCount() > 9) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
