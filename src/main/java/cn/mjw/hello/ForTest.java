/*
 * Copyright 2017 JiaweiMao jiaweiM_philo@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.mjw.hello;

import org.junit.jupiter.api.Test;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.27, 10:37 AM
 */
public class ForTest
{

    @Test
    void test()
    {

        for (int i = 9; i >= 0; i--) {
            System.out.println(i);
        }
    }

    @Test
    void test2()
    {
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j <= 2; j++) {

                double mass = i * 3.018830 + j * 4.022185;
                System.out.println(i + "," + j + "," + mass);

            }
        }

    }
}
