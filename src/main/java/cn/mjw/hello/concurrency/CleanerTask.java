package cn.mjw.hello.concurrency;

import java.util.Date;
import java.util.Deque;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 01 Nov 2019, 3:12 PM
 */
public class CleanerTask extends Thread
{
    private Deque<Event> deque;

    public CleanerTask(Deque<Event> deque)
    {
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run()
    {
        while (true) {
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date)
    {
        if (deque.isEmpty())
            return;

        boolean delete = false;
        long diff;
        do {
            Event e = deque.getLast();
            diff = date.getTime() - e.getDate().getTime();
            if (diff > 10000) {
                System.out.printf("Cleaner: %s\n", e.getEvent());
                deque.removeLast();
                delete = true;
            }
        } while (diff > 10000);
        if (delete) {
            System.out.printf("Cleaner: Size of the queue: %d\n", deque.size());
        }
    }
}
