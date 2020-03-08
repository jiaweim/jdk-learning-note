package trail.concurrency.wang;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 03 Mar 2020, 9:42 PM
 */
public class TryConcurrency
{
    public static void main(String[] args)
    {
        try {
            Thread.sleep(1000*300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
