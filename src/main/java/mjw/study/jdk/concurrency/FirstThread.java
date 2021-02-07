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

package mjw.study.jdk.concurrency;

/**
 * 
 * @author JiaweiM
 * @date Dec 11, 2015 2:02:06 PM
 */
public class FirstThread {

	public static void main(String[] args) {
		HelloThread t = new HelloThread(10);
		t.start();
	}

}

class HelloThread extends Thread {
	private int max;

	public HelloThread(int max) {
		this.max = max;
	}

	@Override
	public void run() {
		for (int i = 0; i < max; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
}
