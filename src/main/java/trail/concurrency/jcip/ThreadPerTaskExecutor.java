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

package trail.concurrency.jcip;

import java.util.concurrent.Executor;

/**
 * 将 Executor 的行为修改为为每个请求都创建新的线程。
 * @author JiaweiMao
 * @version 1.0.0
 * @since 18 Jan 2019, 3:01 PM
 */
public class ThreadPerTaskExecutor implements Executor
{
    @Override public void execute(Runnable command)
    {
        new Thread(command).start();
    }
}
