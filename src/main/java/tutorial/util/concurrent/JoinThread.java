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

package tutorial.util.concurrent;

/**
 * @author JiaweiMao on 2017.05.17
 * @since 1.0-SNAPSHOT
 */
public class JoinThread {

    public static void main(String[] args) {

        Thread thread2 = new Thread(new WaitRunnable());
        Thread thread3 = new Thread(new WaitRunnable());

        System.out.println("Current time millis : " + System.currentTimeMillis());
        thread2.start();

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Current time millis : " + System.currentTimeMillis());

        thread3.start();

        try {
            thread3.join(1000); // 只能一秒，如果没执行完，
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Current time millis : " + System.currentTimeMillis());
    }

    private static class WaitRunnable implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("In thread");
                Thread.sleep(5000);
                System.out.println("In thread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
