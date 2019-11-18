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
 * Sequential web server.
 * 串行处理通过 80 端口接收到的HTTP请求
 * <p>
 * 在实际生产环境中的执行性能很糟糕，因为它每次只能处理一个请求。
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 18 Jan 2019, 2:10 PM
 */
public class SingleThreadWebServer
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Socket connection = socket.accept();
            handleRequest(connection);
        }
    }

    private static void handleRequest(Socket connection)
    {
        // request-handling logic here
    }
}
