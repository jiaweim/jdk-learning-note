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

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 19 Jan 2019, 12:09 PM
 */
public class FixedServer
{
    public static void main(String[] args)
    {
        FixedServer server = new FixedServer();
        for (int i = 0; i < 100; i++) {
            Task task = new Task("Task " + i);
            server.executeTask(task);
        }
        server.endServer();
    }

    private ThreadPoolExecutor executor;

    public FixedServer()
    {
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
    }

    public void executeTask(Task task)
    {
        System.out.print("Server: A new task has arrived\n");
        executor.execute(task);
        System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
        System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
        System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());
        System.out.printf("Server: Task Count: %d\n", executor.getTaskCount());
    }

    public void endServer()
    {
        executor.shutdown();
    }
}
