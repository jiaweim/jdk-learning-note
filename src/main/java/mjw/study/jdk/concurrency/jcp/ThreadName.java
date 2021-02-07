package mjw.study.jdk.concurrency.jcp;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 24 Oct 2019, 10:04 AM
 */
class ThreadName
{
    @Test
    void testDefaultName()
    {
        IntStream.range(0, 5).boxed()
                .map(index -> new Thread(() -> System.out.println(Thread.currentThread().getName())))
                .forEach(Thread::start);
    }

    private static final String PREFIX = "MyThread-";

    @Test
    void testName()
    {
        IntStream.range(0, 3).mapToObj(ThreadName::createThread).forEach(Thread::start);
    }

    private static Thread createThread(int intName)
    {
        return new Thread(() -> System.out.println(Thread.currentThread().getName()), PREFIX + intName);
    }
}
