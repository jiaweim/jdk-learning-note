package trail.concurrency;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 01 Nov 2019, 2:46 PM
 */
public class JoinDemo
{
    private static class DataSourceLoader implements Runnable
    {
        @Override
        public void run()
        {
            System.out.printf("Beginning data sources loading: %s\n", new Date());
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Data sources loading has finished: %s\n", new Date());
        }
    }

    private static class NetworkConnectionsLoader implements Runnable
    {
        @Override
        public void run()
        {

        }
    }


    public static void main(String[] args)
    {
        DataSourceLoader dsLoader = new DataSourceLoader();
        Thread a = new Thread(dsLoader, "DataSource");

        NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
        Thread b = new Thread(ncLoader, "Network");

        a.start();
        b.start();

        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: configuration finshed: %s\n", new Date());
    }
}
