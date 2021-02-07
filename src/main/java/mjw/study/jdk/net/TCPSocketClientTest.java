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

package mjw.study.jdk.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author JiaweiM
 * @date Jul 7, 2015 2:15:50 PM
 */
public class TCPSocketClientTest {

	public static void main(String[] args) {
		
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		
		// ��������IP��ַ
		String serverIP = "127.0.0.1";
		// �������˶˿ں�
		int port = 10000;
		// ��������
		String data = "Hello";
		try {
			// ��������
			socket = new Socket(serverIP, port);
			// ��������
			os = socket.getOutputStream();
			os.write(data.getBytes());
			// ��������
			is = socket.getInputStream();
			byte[] b = new byte[1024];
			int n = is.read(b);
			// ���������Ϣ
			System.out.println("������������"+new String(b,0,n));
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				// �ر���������
				is.close();
				os.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
