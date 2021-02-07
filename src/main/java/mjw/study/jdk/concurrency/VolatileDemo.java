package mjw.study.jdk.concurrency;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 13 Sep 2020, 2:56 PM
 */
public class VolatileDemo
{
    int x = 0;
    volatile boolean v = false;

    public void write()
    {
        x = 42;
        v = true;
    }


}
