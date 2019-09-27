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

package tutorial.util;

import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 15 May 2019, 9:02 PM
 */
public class CalendarTest
{
    @Test
    public void testInstant()
    {
        Instant min = Instant.MIN; //  billion  years ago
        System.out.println(min);
        Instant start = Instant.now();
        for(int i = 0; i< Integer.MAX_VALUE; i++){}
        Instant end = Instant.now();
        Duration timeSlapsed = Duration.between(start, end);
        long millis = timeSlapsed.toMillis();
        System.out.println(millis);
    }

    @Test
    public void testLocalDate(){
        LocalDate localDate = LocalDate.of(2015, 8, 5);
        String s = localDate.getDayOfWeek().toString();
        System.out.println(s);
    }
}
