package tutorial.concurrency.jcp;

import org.testng.annotations.Test;

import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 24 Oct 2019, 10:04 AM
 */
public class ThreadName
{
    @Test
    public void testDefaultName()
    {
        IntStream.range(0, 5).boxed()
                .map(index -> new Thread(() -> System.out.println(Thread.currentThread().getName())))
                .forEach(Thread::start);
    }

    private static final String PREFIX = "ALEX-";

    @Test
    public void testName()
    {
        IntStream.range(0,3).mapToObj(ThreadName::createThread).forEach(Thread::start);
    }

    private static Thread createThread(int intName)
    {
        return new Thread(() -> System.out.println(Thread.currentThread().getName()), PREFIX + intName);
    }
}
