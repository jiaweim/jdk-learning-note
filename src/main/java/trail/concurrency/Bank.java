package trail.concurrency;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 01 Nov 2019, 6:28 PM
 */
public class Bank implements Runnable
{
    private Account account;

    public Bank(Account account)
    {
        this.account = account;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 100; i++) {
            account.subtractAmount(1000);
        }
    }

    public static void main(String[] args)
    {
        Account account = new Account();
        account.setBalance(1000);

        Company company = new Company(account);
        Bank bank = new Bank(account);

        System.out.printf("Account: initial balance %f\n", account.getBalance());
        Thread cyThread = new Thread(company);
        Thread bankThread = new Thread(bank);
        cyThread.start();
        bankThread.start();

        try {
            cyThread.join();
            System.out.println(account.getBalance());
            bankThread.join();
            System.out.printf("Account: final balance %f\n", account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
