/*
 * Copyright 2018 JiaweiMao jiaweiM_philo@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package trail.concurrency.jcc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * 覆盖 beforeExecute() 和 afterExecute() 用来计算任务的运行时间。
 * 覆盖 shutdown() 和 shutdownNow() 方法，将执行器执行的任务的统计信息输出。
 * @author JiaweiMao
 * @version 1.0.0
 * @since 18 Jan 2019, 7:52 PM
 */
public class MyExecutor extends ThreadPoolExecutor
{
    public static void main(String[] args)
    {
        MyExecutor myExecutor = new MyExecutor(2, 4, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        List<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SleepTwoSecondsTask task = new SleepTwoSecondsTask();
            Future<String> result = myExecutor.submit(task);
            results.add(result);
        }
        for (int i = 0; i < 5; i++) {
            try {
                String result = results.get(i).get();
                System.out.printf("Main: Result for Task %d : %s\n", i, result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        myExecutor.shutdown();

        for (int i = 5; i < 10; i++) {
            try {
                String result = results.get(i).get();
                System.out.printf("Main: Result for Task %d : %s\n", i, result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        try {
            myExecutor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main: End of the program.");
    }

    private ConcurrentHashMap<String, Date> startTimes;

    public MyExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue)
    {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        startTimes = new ConcurrentHashMap<>();
    }

    /**
     * 将已执行过的任务、正在执行的任务和等待执行的任务的信息输出到控制台
     */
    @Override public void shutdown()
    {
        System.out.println("MyExecutor: Going to shutdown.");
        System.out.printf("MyExecutor: Executed tasks: %d\n", getCompletedTaskCount());
        System.out.printf("MyExecutor: Running tasks: %d\n", getActiveCount());
        System.out.printf("MyExecutor: Pending tasks: %d\n", getQueue().size());
        super.shutdown();
    }

    @Override public List<Runnable> shutdownNow()
    {
        System.out.println("MyExecutor: Going to immediately shutdown.\n");
        System.out.printf("MyExecutor: Executed tasks: %d\n", getCompletedTaskCount());
        System.out.printf("MyExecutor: Running tasks: %d\n", getActiveCount());
        System.out.printf("MyExecutor: Pending tasks: %d\n", getQueue().size());
        return super.shutdownNow();
    }

    /**
     * 输出要执行的线程的名字、任务的哈希值、开始时间存放到 HashMap 中
     */
    @Override protected void beforeExecute(Thread t, Runnable r)
    {
        System.out.printf("MyExecutor: A task is begining: %s : %s\n", t.getName(), r.hashCode());
        startTimes.put(String.valueOf(r.hashCode()), new Date());
    }

    @Override protected void afterExecute(Runnable r, Throwable t)
    {
        Future<?> result = (Future<?>) r;

        try {
            System.out.println("******************************");
            System.out.println("MyExecutor: A task is finishing.");
            System.out.printf("MyExecutor: Result: %s\n", result.get());
            Date startDate = startTimes.remove(String.valueOf(r.hashCode()));
            Date finishDate = new Date();
            long diff = finishDate.getTime() - startDate.getTime();
            System.out.printf("MyExecutor: Duration: %d\n", diff);
            System.out.println("*******************************");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
