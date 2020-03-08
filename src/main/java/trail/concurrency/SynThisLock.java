package trail.concurrency;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 05 Mar 2020, 7:07 PM
 */
public class SynThisLock
{
    private int count = 10;

    public void m()
    {
        synchronized (this) { // 任何线程要执行下面的代码，必须先拿到 this 的锁
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}
