package mjw.study.jdk.concurrency;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 01 Nov 2019, 6:00 PM
 */
public class MyThreadFactory implements ThreadFactory
{
    private int counter;
    private String name;
    private List<String> stats;

    public MyThreadFactory(String name)
    {
        counter = 0;
        stats = new ArrayList<>();
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r)
    {
        Thread t = new Thread(r, name + "-Thread_" + counter);
        counter++;
        stats.add(String.format("Created thread %d with name %s on %s\n", t.getId(), t.getName(), new Date()));

        return t;
    }

    public String getStats()
    {
        StringBuilder builder = new StringBuilder();
        for (String s : stats) {
            builder.append(s).append("\n");
        }
        return builder.toString();
    }

    private static class Task implements Runnable
    {
        @Override
        public void run()
        {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
    {
        MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
        Task task = new Task();
        for (int i = 0; i < 10; i++) {
            Thread thread = factory.newThread(task);
            thread.start();
        }
        System.out.println("Factory stats:");
        System.out.println(factory.getStats());
    }
}
