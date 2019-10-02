/*
 * Copyright 2018 JiaweiMao jiaweiM_philo@hotmail.com
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
 * @since 29 Sep 2019, 7:53 PM
 */
public class PlusTest {

    @Test
    public void test() {
        System.out.println(10 % 3);
        for (int i = 0; i <= 10; i += 3) {
            System.out.println(i);
        }
    }
}
