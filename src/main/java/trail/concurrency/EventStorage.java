package trail.concurrency;

import java.util.Date;
import java.util.LinkedList;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 01 Nov 2019, 7:37 PM
 */
public class EventStorage
{
    private int maxSize;
    private LinkedList<Date> storage;

    public EventStorage()
    {
        maxSize = 10;
        storage = new LinkedList<>();
    }

    public synchronized void set()
    {
        if (storage.size() == maxSize) {
            try {
                wait(); // 使线程睡眠，释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date()); // 有空余空间
        System.out.printf("Set: %d\n", storage.size());
        notifyAll(); // 唤醒其它线程
    }

    public synchronized void get()
    {
        if (storage.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Get: %d: %s\n", storage.size(), storage.poll());
        notifyAll();
    }

    public static void main(String[] args)
    {
        EventStorage storage = new EventStorage();
        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);

        thread1.start();
        thread2.start();
    }

}
