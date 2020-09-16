package cn.mjw.hello.concurrency;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 01 Nov 2019, 3:05 PM
 */
public class Event
{
    private Date date;
    private String event;

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getEvent()
    {
        return event;
    }

    public void setEvent(String event)
    {
        this.event = event;
    }

    public static void main(String[] args)
    {
        Deque<Event> deque = new ConcurrentLinkedDeque<>();
        WriterTask writerTask = new WriterTask(deque);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(writerTask);
            thread.start();
        }
        CleanerTask cleanerTask = new CleanerTask(deque);
        cleanerTask.start();
    }
}
