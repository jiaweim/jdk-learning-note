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

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 通过为每个请求创建一个新的线程来提供服务，从而实现更高的响应性.
 * <p>
 * 和 {@link SingleThreadWebServer} 的区别在于，对每个连接，主循环都创建一个新线程来处理请求。从而：
 * 任务处理过程从主线程中分离出来，使得主循环能够更快地重新等待下一个到来的连接。这使得程序在完成前面的请求之前可以接受新的请求，
 * 从而提高响应性。
 * 任何可以并行处理，从而能同时服务多个请求。如果有多个服务器，或者任务由于某种原因被阻塞，例如等待 I/O 完成、获取锁或者资源可用性等，程序
 * 的吞吐量将得到提高。
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 18 Jan 2019, 2:17 PM
 */
public class ThreadPerTaskWebServer
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = () -> handleRequest(connection);
            new Thread(task).start();
        }
    }

    private static void handleRequest(Socket connection)
    {
        // request-handling logic here
    }
}
