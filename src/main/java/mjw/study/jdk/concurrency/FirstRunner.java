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
 * @author	JiaweiM
 * @date	Dec 11, 2015 2:08:30 PM
 */
public class FirstRunner {
	public static void main(String[] args) {
		HelloRunner r = new HelloRunner(1000);
		Thread t1 = new Thread(r, "[线程 One]");
		Thread t2 = new Thread(r, "[线程 Two]");
		t1.start();
	}
}

class HelloRunner implements Runnable{

	int max;
	
	public HelloRunner(int max) {
		this.max = max;
	}

	@Override
	public void run() {
		for(;max > 0; max--){
			System.out.println(Thread.currentThread().getName()+":"+max);
		}
	}
}
