package trail.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 对业务写方法加锁
 * 对业务读方法不加锁
 * 容易产生脏读问题（dirtyRead）
 */
public class Account2
{
    private String name;
    double balance;

    public synchronized void set(String name, double balance)
    {
        this.name = name;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public double getBalance(String name)
    {
        return this.balance;
    }

    public static void main(String[] args)
    {
        Account2 account2 = new Account2();
        new Thread(() -> account2.set("zhangshan", 100)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account2.getBalance("zhangshan"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account2.getBalance("zhangshan"));
    }
}
