package mjw.study.jdk;

import org.junit.jupiter.api.Test;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.24, 2:43 PM
 */
 class SwitchTest
{
    /**
     * If switch is coupled with while loop, what if we put a continue keyword in the switch:
     * continue of the switch
     */
    @Test
    void test()
    {
        int i = 10;
        while (i > 0) {

            switch (i) {
                case 5:
                    System.out.println(i);
                    break;
                case 3:
                    continue;
                case 6:
                    break;
            }

            System.out.println("o:" + i);

            i--;
        }

    }

}
