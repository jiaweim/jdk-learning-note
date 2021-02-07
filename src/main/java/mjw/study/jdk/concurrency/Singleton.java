package mjw.study.jdk.concurrency;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 12 Sep 2020, 4:37 PM
 */
public class Singleton
{
    private static Singleton instance;

    public static Singleton getInstance()
    {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
