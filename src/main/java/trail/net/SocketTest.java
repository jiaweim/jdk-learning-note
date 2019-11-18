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

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * This program makes a socket connection to the atomic clock in Boulder,
 * Colorado, and prints the time that the server sends.
 * 
 * @author JiaweiMao
 * @date Jan 16, 2016 10:26:17 PM
 */
public class SocketTest {
	
	public static void main(String[] args) throws IOException {
		try (Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13)) {
			InputStream inStream = s.getInputStream();
			Scanner in = new Scanner(inStream);

			while (in.hasNextLine()) {
				String line = in.nextLine();
				System.out.println(line);
			}
		}
	}
}
