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

import java.io.*;

import java.net.*;

/**
 * �������ӵ�echo������ ���ܣ����ͻ��˷��͵����ݷ������ͻ���
 * 
 * @Class MulSocketServer
 * @author JiaweiM
 * @date Jul 7, 2015 4:51:34 PM
 */
public class TCPMulSocketServer {

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		Socket socket = null;
		OutputStream os = null;
		InputStream is = null;

		// �����˿ں�
		int port = 10000;

		try {

			// ��������
			serverSocket = new ServerSocket(port);
			System.out.println("��������������");

			// �������
			socket = serverSocket.accept();

			// ��ʼ����
			is = socket.getInputStream();
			os = socket.getOutputStream();

			byte[] b = new byte[1024];

			for (int i = 0; i < 3; i++) {

				int n = is.read(b);

				// ���
				System.out.println("�ͻ��˷�������Ϊ��" + new String(b, 0, n));

				// ��ͻ��˷��ͷ�������
				os.write(b, 0, n);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				// �ر���������
				os.close();
				is.close();
				socket.close();
				serverSocket.close();
			} catch (Exception e) {
			}

		}

	}

}
