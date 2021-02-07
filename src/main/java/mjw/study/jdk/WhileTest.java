package mjw.study.jdk;

import org.junit.jupiter.api.Test;

/**
 * @author JiaweiMao 2017.03.27
 * @since 1.0-SNAPSHOT
 */
class WhileTest
{
    @Test
    void test()
    {
        int count = 3;
        while (count-- > 0) {
            System.out.println(1);
            System.out.println("count=" + count);
        }
    }

}
