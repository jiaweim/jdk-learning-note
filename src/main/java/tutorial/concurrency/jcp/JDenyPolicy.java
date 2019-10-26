package tutorial.concurrency.jcp;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 25 Oct 2019, 10:35 AM
 */
public interface JDenyPolicy
{
    void reject(Runnable runnable, JThreadPool threadPool);

    /**
     * 直接舍弃，不作其它处理
     */
    class JDiscardDenyPolicy implements JDenyPolicy
    {
        @Override
        public void reject(Runnable runnable, JThreadPool threadPool)
        {
            // do nothing
        }
    }

    /**
     * 舍弃并抛出异常
     */
    class JAbortDenyPolicy implements JDenyPolicy
    {

        @Override
        public void reject(Runnable runnable, JThreadPool threadPool)
        {
            throw new JRunnableDenyException("The task " + runnable + " is abort.");
        }
    }

    /**
     * 接受并执行
     */
    class JRunnerDenyPolicy implements JDenyPolicy
    {
        @Override
        public void reject(Runnable runnable, JThreadPool threadPool)
        {
            if (!threadPool.isShutdown()) {
                runnable.run();
            }
        }
    }
}
