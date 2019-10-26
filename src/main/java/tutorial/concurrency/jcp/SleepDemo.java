package tutorial.concurrency.jcp;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 24 Oct 2019, 1:42 PM
 */
public class SleepDemo
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread thread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            System.out.println(String.format("spend %d ms", (endTime - startTime)));
        });
        thread.start();

        long st = System.currentTimeMillis();
        Thread.sleep(3000);
        long ed = System.currentTimeMillis();
        System.out.println(String.format("Main time %d ms", (ed - st)));
    }
}
