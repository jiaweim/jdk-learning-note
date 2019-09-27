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

import static org.testng.Assert.*;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.10.15, 9:37 AM
 */
public class DoubleToFloat
{
    @Test
    public void test()
    {
        double d = 520.85944;
        float f = (float) d;
        System.out.println(f);
    }

    @Test
    public void testCompare()
    {
        Double a = Double.NaN;
        Double b = Double.NaN;
        Double c = 0.;
        Double d = 1.;

        assertEquals(a, b);

        System.out.println(Double.compare(a, c));
        System.out.println(Double.compare(c, a));
        System.out.println(Double.compare(c, d));
    }
}
