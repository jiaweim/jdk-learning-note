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

package trail.concurrency.sync;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 18 Jan 2019, 12:57 PM
 */
public class Account
{
    private double balance;

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public synchronized void addAmount(double amount)
    {
        double tmp = balance;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp += amount;
        balance = tmp;
    }

    /**
     * 通过临时变量 tmp 存储账户余额，制造一个错误情景：临时变量先获取账户余额，然后进行数额累加，之后把最终结果更新为账户余额。
     * 此外，通过 sleep() 方法增加延时，使得正在执行这个方法的线程休眠 10 ms，而此时其他线程也可能会执行这个方法，因此可能会
     * 改变账户余额，引发错误。
     * 而 synchronized 关键字避免了这类错误的发生。
     */
    public synchronized void subtractAmount(double amount)
    {
        double tmp = balance;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp -= amount;
        balance = tmp;
    }

    public static void main(String[] args)
    {
        Account account = new Account();
        account.setBalance(1000);

        Company company = new Company(account);
        Thread companyThread = new Thread(company);

        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);

        // 输出初始金额
        System.out.printf("Account : Initial Balance: %f\n", account.getBalance());
        companyThread.start();
        bankThread.start();

        // 使用 join() 等待这两个线程运行完成，然后输出最终金额
        try {
            companyThread.join();
            bankThread.join();
            System.out.printf("Account : Final Balance: %f\n", account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
