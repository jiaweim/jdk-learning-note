package mjw.study.jdk.concurrency;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 01 Nov 2019, 6:56 PM
 */
public class Company implements Runnable
{
    private Account account;

    public Company(Account account)
    {
        this.account = account;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 100; i++) {
            account.addAmount(1000);
        }
    }
}
