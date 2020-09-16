package cn.mjw.hello;

import org.junit.jupiter.api.Test;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 21 Jul 2016, 19:07
 */
class CaseTest
{
    @Test
    void testMultiCondition()
    {
        for (int i = 0; i < 10; i++) {
            int k = 0;
            switch (i) {
                case 1:
                case 2:
                case 3:
                    k = 3;
                    break;
                case 4:
                case 5:
                case 6:
                    k = 6;
                    break;
                default:
                    break;
            }
            System.out.println(k);
        }
    }
}
