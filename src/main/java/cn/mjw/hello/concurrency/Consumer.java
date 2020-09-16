package cn.mjw.hello.concurrency;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 01 Nov 2019, 7:46 PM
 */
public class Consumer implements Runnable
{
    private EventStorage storage;

    public Consumer(EventStorage storage)
    {
        this.storage = storage;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 100; i++) {
            storage.get();
        }
    }
}
