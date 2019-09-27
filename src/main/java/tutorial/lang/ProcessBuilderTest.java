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

package tutorial.lang;

import java.io.IOException;

/**
 * 
 * @Class	ProcessBuilderTest
 * @author	JiaweiM
 * @date	Jul 9, 2015 3:50:03 PM
 */
public class ProcessBuilderTest {
	
	public static void main(String[] args) throws IOException, InterruptedException{
		ProcessBuilder pb = new ProcessBuilder("echo","This is ProcessBuilder Example");
		System.out.println("Run echo command");
		Process process = pb.start();
		int errCode = process.waitFor();
		System.out.println("Echo command executed, any errors? ");
	}

}
