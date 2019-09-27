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

package tutorial.lang;

import org.testng.annotations.Test;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 26 Oct 2018, 10:47 AM
 */
public class DoubleTest
{
    @Test
    public void testCompare()
    {
        Double a = 1.;
        Double b = Double.NaN;
        int compare = Double.compare(a, b);
        System.out.println(compare);
    }
}
