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

package tutorial.lang;


import org.testng.annotations.Test;

import java.time.LocalDate;

/**
 * A date without a time-zone
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2017.01.17, 3:41 PM
 */
public class LocalDateTest {

    @Test
    void ctr1(){
        // 获得当前日期
        LocalDate now = LocalDate.now();

        int year = now.getYear();
        System.out.println(year);

    }

}
