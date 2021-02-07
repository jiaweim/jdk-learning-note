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

package mjw.study.jdk.util.concurrent;

/**
 * @author JiaweiMao on 2017.05.17
 * @since 1.0-SNAPSHOT
 */
public class SyncDemo {

    public static void main(String[] args) {

        Sender sender = new Sender();
        ThreadSend s1 = new ThreadSend("Hi", sender);
        ThreadSend s2 = new ThreadSend("Bye", sender);

        s1.start();
        s2.start();

        try {
            s1.join();
            s2.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}

class Sender {
    public void send(String msg) {
        System.out.println("Sending\t" + msg);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
        System.out.println("\n" + msg + " Sent");
    }
}

class ThreadSend extends Thread {
    private String msg;
    Sender sender;

    ThreadSend(String m, Sender sender) {
        this.msg = m;
        this.sender = sender;
    }

    @Override
    public void run() {
        synchronized (sender) {
            sender.send(msg);
        }
    }
}
