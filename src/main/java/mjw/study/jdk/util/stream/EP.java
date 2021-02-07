package mjw.study.jdk.util.stream;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 18 Nov 2019, 3:28 PM
 */
public class EP
{
    private int id;
    private String name;
    private double wage;

    public EP(int id, String name, double wage)
    {
        this.id = id;
        this.name = name;
        this.wage = wage;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public double getWage()
    {
        return wage;
    }
}
