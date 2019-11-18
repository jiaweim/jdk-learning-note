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

package trail.net;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 
 * @author JiaweiM
 * @version 14.11.2013 09:04:07
 */
public class UdpPorttest {
	public static void main(String[] args) {
		for (int port = 1; port <= 65535; port++) {
			try {
				DatagramSocket socket = new DatagramSocket(port);
				socket.close();
			} catch (SocketException e) {
				System.out.println("Port is in use: " + port);
			}

		}
	}
}
