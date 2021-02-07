package mjw.study.jdk.concurrency;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 04 Mar 2020, 9:45 PM
 */
public class ThreadGroupMethod extends Thread
{
    public ThreadGroupMethod(ThreadGroup group, String name)
    {
        super(group, name);
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
            }
        }
        System.out.println(Thread.currentThread().getName() + " completed executing");
    }

    public static void main(String[] args)
    {
        // creating a ThreadGroup
        ThreadGroup g1 = new ThreadGroup("Parent thread");
        // creating a child ThreadGroup for parent ThreadGroup
        ThreadGroup g2 = new ThreadGroup(g1, "child thread");

        // creating a thread
        ThreadGroupMethod t1 = new ThreadGroupMethod(g1, "Thread-1");
        t1.start();
        // creating another thread
        ThreadGroupMethod t2 = new ThreadGroupMethod(g1, "Thread-2");
        t2.start();

        // Check for access permission of current running thread
        g1.checkAccess();
        System.out.println(g1.getName() + " has access");
        g2.checkAccess();
        System.out.println(g2.getName() + " has access");
    }
}
