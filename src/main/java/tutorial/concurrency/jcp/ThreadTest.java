package tutorial.concurrency.jcp;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 24 Oct 2019, 11:01 AM
 */
public class ThreadTest
{
    @Test
    public void testThreadGroup()
    {
        Thread t1 = new Thread("t1");
        ThreadGroup group = new ThreadGroup("group1");
        Thread t2 = new Thread(group, "t2");
        ThreadGroup testGroup = Thread.currentThread().getThreadGroup();
        assertEquals(testGroup.getName(), "main");
        assertSame(testGroup, t1.getThreadGroup());
        assertSame(group, t2.getThreadGroup());
        assertNotEquals(testGroup, t2.getThreadGroup());
    }

    @Test
    public void testDaemon() throws InterruptedException
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

    @Test
    public void testSleep()
    {

    }

    @Test
    public void pint()
    {
        System.out.println(2000L);
    }
}
