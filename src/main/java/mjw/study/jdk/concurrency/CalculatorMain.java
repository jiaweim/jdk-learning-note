package mjw.study.jdk.concurrency;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 17 Jan 2019, 1:25 PM
 */
class CalculatorMain
{
    @Test
    void testState()
    {
        Thread[] threads = new Thread[10];
        Thread.State[] status = new Thread.State[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator(i));
            if ((i % 2) == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread " + i);
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(".\\log.txt")); PrintWriter pw = new PrintWriter(writer)) {
            // 写入线程当前状态， NEW
            for (int i = 0; i < 10; i++) {
                pw.println("Main: status of Thread " + i + " : " + threads[i].getState());
                status[i] = threads[i].getState();
                assertEquals(threads[i].getState(), Thread.State.NEW);
            }

            // 执行线程
            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }

            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState() != status[i]) {
                        writeThreadInfo(pw, threads[i], status[i]);
                        status[i] = threads[i].getState();
                    }
                }
                finish = true;
                for (int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state)
    {
        pw.printf("Main: ID %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main: Priority: %d\n", thread.getPriority());
        pw.printf("Main: Old State: %s\n", state);
        pw.printf("Main: New State: %s\n", thread.getState());
        pw.printf("Main: *******************************\n");
    }
}
