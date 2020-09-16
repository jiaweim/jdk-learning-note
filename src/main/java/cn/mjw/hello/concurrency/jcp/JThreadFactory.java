package cn.mjw.hello.concurrency.jcp;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 25 Oct 2019, 10:32 AM
 */
public interface JThreadFactory
{
    /**
     * Create a Thread for a task
     */
    Thread createThread(Runnable runnable);
}
