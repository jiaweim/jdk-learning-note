package cn.mjw.hello.lang;


/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 20 Oct 2017, 4:07 PM
 */
public class HashTest
{

    private Integer key;
    private String name;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashTest hashTest = (HashTest) o;

        if (key != null ? !key.equals(hashTest.key) : hashTest.key != null) return false;
        return name != null ? name.equals(hashTest.name) : hashTest.name == null;
    }

    @Override
    public int hashCode()
    {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

}
