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

package tutorial.net;

import java.io.OutputStream;

import java.io.InputStream;

import java.net.Socket;

/**
 * 
 * @author	JiaweiM
 * @date	Jul 7, 2015 4:56:29 PM
 */
public class TCPLogicThread extends Thread{
	
	Socket socket;
	InputStream is;
	OutputStream os;
	
	public TCPLogicThread(Socket socket){
		this.socket = socket;
		start();	// �����߳�
	}
	
	@Override
	public void run(){
		byte[] b = new byte[1024];
		try {
			os = socket.getOutputStream();
			is = socket.getInputStream();
			for(int i=0; i< 3; i++){
				// ��ȡ����
				int n = is.read(b);
				// �߼�����
				byte[] response = logic(b, 0, n);
				// ��������
				os.write(response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			close();
		}
	}
	
	/**
	 * �ر���������
	 */
	private void close(){
		try {
			os.close();
			is.close();
			socket.close();
		} catch (Exception e) {
		}
	}
	
	/**
	 * �߼���������ʵ��echo�߼�
	 * @param b �ͻ��˷������ݻ�����
	 * @param off ��ʼ�±�
	 * @param len ��Ч���ݳ���
	 * @return 
	 */
	private byte[] logic(byte[] b, int off, int len){
		byte[] res = new byte[len];
		System.arraycopy(b, 0, res, 0, len);
		return res;
	}
	

}
