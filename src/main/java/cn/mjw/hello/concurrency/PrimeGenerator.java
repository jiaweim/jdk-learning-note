/*
 * Copyright 2018 JiaweiMao jiaweiM_philo@hotmail.com
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

package cn.mjw.hello.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 17 Jan 2019, 8:03 PM
 */
public class PrimeGenerator extends Thread
{
    @Override
    public void run()
    {
        long number = 1L;
        while (true) {
            if (isPrime(number))
                System.out.printf("Number %d is Prime\n", number);

            if (isInterrupted()) {
                System.out.println("The Prime Generator has been Interrupted");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long number)
    {
        if (number <= 2)
            return true;
        for (long i = 2; i < number; i++) {
            if ((number % i) == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        Thread thread = new PrimeGenerator();
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
