package cn.mjw.hello.concurrency.jcp;

import java.util.LinkedList;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 25 Oct 2019, 4:11 PM
 */
public class JLinkedTaskQueue implements JTaskQueue
{
    // 容量
    private final int limit;

    private final JDenyPolicy denyPolicy;

    private final LinkedList<Runnable> taskList = new LinkedList<>();

    private final JThreadPool threadPool;

    public JLinkedTaskQueue(int limit, JDenyPolicy denyPolicy, JThreadPool threadPool)
    {
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }

    @Override
    public void offer(Runnable runnable)
    {

    }

    @Override
    public Runnable take()
    {
        return null;
    }

    @Override
    public int size()
    {
        return 0;
    }
}
