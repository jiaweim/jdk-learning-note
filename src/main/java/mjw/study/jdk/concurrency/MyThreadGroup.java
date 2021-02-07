package mjw.study.jdk.concurrency;

import java.util.Random;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 01 Nov 2019, 5:44 PM
 */
public class MyThreadGroup extends ThreadGroup
{
    public MyThreadGroup(String name)
    {
        super(name);
    }

    /**
     * match uncaught Exception, output the message and interrupt other threads.
     */
    @Override
    public void uncaughtException(Thread t, Throwable e)
    {
        System.out.printf("The thread %s has thrown an Exception\n", t.getId());
        e.printStackTrace(System.out);
        System.out.println("Terminating the rest of the Threads");
        interrupt(); // interrupt all threads in the group
    }

    private static class Task implements Runnable
    {
        @Override
        public void run()
        {
            int result;
            Random random = new Random(Thread.currentThread().getId());
            while (true) {
                result = 1000 / ((int) (random.nextDouble() * 1000));
                System.out.printf("%s : %d\n", Thread.currentThread().getId(), result);
                if (Thread.currentThread().isInterrupted()) { // detect interrupt
                    System.out.printf("%d : Interrupted\n", Thread.currentThread().getId());
                    return;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        MyThreadGroup group = new MyThreadGroup("My Group");
        Task task = new Task();
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(group, task);
            thread.start();
        }
    }
}
