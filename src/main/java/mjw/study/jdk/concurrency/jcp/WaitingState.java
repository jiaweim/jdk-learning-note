package mjw.study.jdk.concurrency.jcp;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 04 Mar 2020, 10:12 AM
 */
public class WaitingState implements Runnable
{
    public static Thread t1;

    public static void main(String[] args)
    {
        t1 = new Thread(new WaitingState());
        t1.start();
    }

    @Override
    public void run()
    {
        Thread t2 = new Thread(new WaitingThread());
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    class WaitingThread implements Runnable
    {
        @Override
        public void run()
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println(WaitingState.t1.getState());
        }
    }
}
