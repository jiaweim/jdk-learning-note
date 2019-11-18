package trail.concurrency;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 01 Nov 2019, 7:25 PM
 */
public class TicketOffice2 implements Runnable
{
    private Cinema cinema;

    public TicketOffice2(Cinema cinema)
    {
        this.cinema = cinema;
    }

    @Override
    public void run()
    {
        cinema.sellTickets2(2);
        cinema.sellTickets2(4);
        cinema.sellTickets1(2);
        cinema.sellTickets1(1);
        cinema.returnTickets2(2);
        cinema.sellTickets1(3);
        cinema.sellTickets2(2);
        cinema.sellTickets1(2);
    }
}
