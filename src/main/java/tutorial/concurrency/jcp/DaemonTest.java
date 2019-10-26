package tutorial.concurrency.jcp;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 24 Oct 2019, 1:04 PM
 */
public class DaemonTest
{
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
