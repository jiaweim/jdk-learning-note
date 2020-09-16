package cn.mjw.hello.concurrency.jcp;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 06 Mar 2020, 4:04 PM
 */
public class Server
{
    private ThreadPoolExecutor executor;

    public Server()
    {
        this.executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }

    public void executeTask(Task task)
    {
        System.out.println("Server: A new task has arrived");
        executor.execute(task);
        System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
        System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
    }

    public void endServer()
    {
        executor.shutdown();
    }

    public static void main(String[] args)
    {
        Server server = new Server();
        for (int i = 0; i < 100; i++) {
            Task task = new Task("Task " + i);
            server.executeTask(task);
        }
        server.endServer();
    }
}
