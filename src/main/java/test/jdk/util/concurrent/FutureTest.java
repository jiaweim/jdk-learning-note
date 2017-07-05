/*
 * Copyright 2017 JiaweiMao jiaweiM_philo@hotmail.com
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

package test.jdk.util.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Callable 和 Runnable 一样，只不过该放方法有一个泛型返回值类型。
 * 线程属于异步计算模型，所以你不能直接从别的线程中得到函数返回值。Future 可以监视目标线程调用 call 的情况，当你调用
 * Future 的 get() 方法以获得结果时，当前线程阻塞，直接 call 方法结束返回结果。
 *
 * @author JiaweiMao on 2017.05.23
 * @since 1.0-SNAPSHOT
 */
public class FutureTest {

    public static class Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            String tid = String.valueOf(Thread.currentThread().getId());
            System.out.printf("Thread#%s : in call\n", tid);
            return tid;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Future<String>> results = new ArrayList<Future<String>>();
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++)
            results.add(es.submit(new Task()));

        for (Future<String> res : results)
            System.out.println(res.get());
    }
}
