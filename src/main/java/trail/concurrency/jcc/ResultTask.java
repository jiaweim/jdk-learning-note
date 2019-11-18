package trail.concurrency.jcc;

import java.util.concurrent.Callable;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 24 Oct 2019, 7:43 PM
 */
public class ResultTask implements Callable<Result>
{
    private String name;

    public ResultTask(String name)
    {
        this.name = name;
    }

    @Override
    public Result call() throws Exception
    {
        System.out.printf("%s: Staring\n", name);

        long duration = (long) (Math.random() * 10);
        System.out.printf("%s: Waiting %d seconds for results");

        return null;
    }
}
