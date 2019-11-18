package trail.concurrency.jcp;

import java.util.stream.IntStream;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 24 Oct 2019, 1:57 PM
 */
public class YieldEx
{
    public static void main(String[] args)
    {
        IntStream.range(0, 3).mapToObj(YieldEx::create).forEach(Thread::start);
    }

    private static Thread create(int index)
    {
        return new Thread(() -> {
            if (index == 0)
                Thread.yield();
            System.out.println(index);
        });
    }
}
