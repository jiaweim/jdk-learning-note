package trail.concurrency;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 01 Nov 2019, 7:45 PM
 */
public class Producer implements Runnable
{
    private EventStorage storage;

    public Producer(EventStorage storage)
    {
        this.storage = storage;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 100; i++) {
            storage.set();
        }
    }
}
