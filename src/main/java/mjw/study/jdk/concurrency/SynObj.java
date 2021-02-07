package mjw.study.jdk.concurrency;

/**
 * synchronized 关键字。
 * 对某个对象加锁。
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 05 Mar 2020, 6:58 PM
 */
public class SynObj
{
    private int count = 10;
    private Object o = new Object();

    public void m()
    {
        synchronized (o) { // 任何线程要执行下面的代码，必须先拿到 o 的锁
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}
