package trail.concurrency.jcp;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 24 Oct 2019, 8:56 AM
 */
public class TicketWindow extends Thread
{
    private final String name;

    private static final int MAX = 50;
    private static int index = 1;

    public TicketWindow(String name)
    {
        this.name = name;
    }

    @Override
    public void run()
    {
        while (index <= MAX) {
            System.out.println("柜台: " + name + " 当前号码: " + (index++));
        }
        super.run();
    }

    public static void main(String[] args)
    {
        TicketWindow window1 = new TicketWindow("一号机");
        window1.start();

        TicketWindow window2 = new TicketWindow("二号机");
        window2.start();

        TicketWindow window3 = new TicketWindow("三号机");
        window3.start();

        TicketWindow window4 = new TicketWindow("四号机");
        window4.start();
    }
}
