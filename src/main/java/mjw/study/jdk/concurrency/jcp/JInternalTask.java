package mjw.study.jdk.concurrency.jcp;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 25 Oct 2019, 10:46 AM
 */
public class JInternalTask implements Runnable
{
    private final JTaskQueue taskQueue;

    private volatile boolean running = true;

    public JInternalTask(JTaskQueue taskQueue)
    {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run()
    {
        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                Runnable task = taskQueue.take();
                task.run();
            } catch (Exception e) {
                running = false;
                break;
            }
        }
    }

    /**
     * 停止当前任务
     */
    public void  stop(){
        this.running = false;
    }
}
