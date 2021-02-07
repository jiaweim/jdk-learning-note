package mjw.study.jdk.concurrency;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 01 Nov 2019, 7:19 PM
 */
public class Cinema
{
    private long vacanciesCinema1;
    private long vacanciesCinema2;

    private final Object controlCinema1, controlCinima2;

    public Cinema()
    {
        controlCinema1 = new Object();
        controlCinima2 = new Object();
        vacanciesCinema1 = 20;
        vacanciesCinema2 = 20;
    }

    public boolean sellTickets1(int number)
    {
        synchronized (controlCinema1) {
            if (number < vacanciesCinema1) {
                vacanciesCinema1 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean sellTickets2(int number)
    {
        synchronized (controlCinima2) {
            if (number < vacanciesCinema2) {
                vacanciesCinema2 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean returnTickets1(int number)
    {
        synchronized (controlCinema1) {
            vacanciesCinema1 += number;
            return true;
        }
    }

    public boolean returnTickets2(int number)
    {
        synchronized (controlCinima2) {
            vacanciesCinema2 += number;
            return true;
        }
    }

    public long getVacanciesCinema1()
    {
        return vacanciesCinema1;
    }

    public long getVacanciesCinema2()
    {
        return vacanciesCinema2;
    }

    public static void main(String[] args)
    {
        Cinema cinema = new Cinema();
        TicketOffice1 office1 = new TicketOffice1(cinema);
        TicketOffice2 office2 = new TicketOffice2(cinema);

        Thread thread1 = new Thread(office1, "Office1");
        Thread thread2 = new Thread(office2, "Office2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Room 1 Vacancies: %d\n", cinema.getVacanciesCinema1());
        System.out.printf("Room 2 Vacancies: %d\n", cinema.getVacanciesCinema2());
    }
}
