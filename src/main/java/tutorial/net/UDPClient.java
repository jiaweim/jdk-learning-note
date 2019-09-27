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

package tutorial.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 
 * @author JiaweiM
 * @version 14.11.2013 09:35:28
 */
public class UDPClient {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket();

			InetAddress hostAddress = InetAddress.getByName("localHost");
			String msg = "Hello, I'm client!";
			DatagramPacket sendPacket = new DatagramPacket(msg.getBytes(), msg.length(), hostAddress, 12345);
			socket.send(sendPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
