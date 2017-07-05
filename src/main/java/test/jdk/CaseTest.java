// Created at 2016/7/21
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

package test.jdk;


import org.junit.jupiter.api.Test;

/**
 * @version 1.0.0
 * @author  JiaweiMao
 * @date	21 Jul 2016, 19:07
 */
public class CaseTest {

    @Test
    public void testMultiCondition() {
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
