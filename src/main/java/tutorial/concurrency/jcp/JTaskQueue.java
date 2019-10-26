package tutorial.concurrency.jcp;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 25 Oct 2019, 10:30 AM
 */
public interface JTaskQueue
{
    /**
     * add a task to the queue
     */
    void offer(Runnable runnable);

    /**
     * @return task a task from the header
     */
    Runnable take();

    /**
     * @return number of task in this queue
     */
    int size();
}
