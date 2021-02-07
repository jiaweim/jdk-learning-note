package mjw.study.jdk.concurrency;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 01 Nov 2019, 3:39 PM
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler
{
    @Override
    public void uncaughtException(Thread t, Throwable e)
    {
        System.out.println("An exception has been captured");
        System.out.printf("Thread: %s\n", t.getId());
        System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
        System.out.println("Stack Trace: ");
        e.printStackTrace(System.out);
        System.out.printf("Thread status: %s\n", t.getState());
    }

    public static void main(String[] args)
    {
        Runnable task = () -> {
            Integer.parseInt("ASV");
        };

        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}
