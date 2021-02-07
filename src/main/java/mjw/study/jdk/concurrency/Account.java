package mjw.study.jdk.concurrency;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 01 Nov 2019, 6:23 PM
 */
public class Account
{
    private double balance;

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

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }
}
