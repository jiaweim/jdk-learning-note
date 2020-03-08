package trail.concurrency;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 05 Mar 2020, 7:14 PM
 */
public class SynMethod
{
    private int count = 10;

    public synchronized void m(){ // 等价于从方法开始使用 synchronized(this)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
}
