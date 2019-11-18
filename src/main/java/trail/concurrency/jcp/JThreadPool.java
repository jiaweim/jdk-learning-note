package trail.concurrency.jcp;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 25 Oct 2019, 10:25 AM
 */
public interface JThreadPool
{
    /**
     * submit task to thread pool
     */
    void execute(Runnable runnable);

    /**
     * close thread pool
     */
    void shutdown();

    /**
     * @return the initial size of the thread pool
     */
    int getInitSize();

    /**
     * @return the allowed maximum number of threads
     */
    int getMaxSize();

    /**
     * @return the number of core threads
     */
    int getCoreSize();

    /**
     * @return the queue size
     */
    int getQueueSize();

    /**
     * @return the number of active threads
     */
    int getActiveCount();

    /**
     * @return true if this pool is shutdown
     */
    boolean isShutdown();
}
