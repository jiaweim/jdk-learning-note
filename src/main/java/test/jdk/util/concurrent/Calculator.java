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

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author JiaweiMao on 2017.05.24
 * @since 1.0-SNAPSHOT
 */
public class Calculator implements Runnable {

    private int number;

    public Calculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++)
            System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, i * number);
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        Thread.State[] state = new Thread.State[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator(i));
            if ((i % 2) == 0)
                threads[i].setPriority(Thread.MAX_PRIORITY);
            else
                threads[i].setPriority(Thread.MIN_PRIORITY);
            threads[i].setName("Thread " + i);
        }

        try (FileWriter fileWriter = new FileWriter(".\\log.txt"); PrintWriter pw = new PrintWriter(fileWriter)) {
            for (int i = 0; i < 10; i++) {
                pw.println("Main: Status of Thread " + i + " : " + threads[i].getState());
                state[i] = threads[i].getState();
            }
            for (int i = 0; i < 10; i++)
                threads[i].start();

            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState() != state[i]) {
                        writeThreadInfo(pw, threads[i], state[i]);
                        state[i] = threads[i].getState();
                    }
                }
                finish = true;
                for (int i = 0; i < 10; i++)
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {

        pw.printf("Main : ID %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State: %s\n", state);
        pw.printf("Main : New State: %s\n", thread.getState());
        pw.printf("Main : *************************************\n");
    }
}
