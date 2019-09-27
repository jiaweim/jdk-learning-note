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

package tutorial;


import org.testng.annotations.Test;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 21 Jul 2016, 19:07
 */
public class CaseTest
{

    @Test
    public void testMultiCondition()
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
