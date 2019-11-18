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

/**
 * 
 * @version 1.00
 */

package trail.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author	JiaweiM
 * @date	Jul 7, 2015 5:02:56 PM
 */
public class TCPMulThreadSocketServer {
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		// �����˿ں�
		int port = 10000;
		try {
			// ��������
			serverSocket = new ServerSocket(port);
			while(true){
				// �������
				socket = serverSocket.accept();
				new TCPLogicThread(socket);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
