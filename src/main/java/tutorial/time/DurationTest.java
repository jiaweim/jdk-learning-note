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

package tutorial.time;


import org.testng.annotations.Test;

import java.time.Duration;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.10.03, 10:58 PM
 */
public class DurationTest
{

    @Test
    public void parse()
    {
        String s = "PT1597.46S";
        Duration duration = Duration.parse(s);
        System.out.println(duration.getSeconds());
    }

}
