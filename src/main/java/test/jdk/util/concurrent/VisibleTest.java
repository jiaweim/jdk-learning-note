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

package test.jdk.util.concurrent;

/**
 * @author JiaweiMao on 2017.05.24
 * @since 1.0-SNAPSHOT
 */
public class VisibleTest {

    private volatile static boolean ready;
    private volatile static int number;
    private volatile static int count;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            synchronized (this){

            }
            while (!ready) {
                System.out.println(System.currentTimeMillis() + " 计数 " + count++);
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++)
            new ReaderThread().start();
        number = 11;
        ready = true;
    }
}
