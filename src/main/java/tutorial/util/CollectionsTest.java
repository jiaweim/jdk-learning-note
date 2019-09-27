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

/**
 * @version 1.00
 */

package tutorial.util;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author JiaweiM
 * @date Aug 13, 2015 10:55:48 AM
 */
public class CollectionsTest
{

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testUnmodifiableSet()
    {
        Set<String> set = new HashSet<String>();
        set.add("Welcome");
        set.add("to");
        set.add("tp");

        Set<String> unmodSet = Collections.unmodifiableSet(set);
        // modified operation is not supported on unmodifiableSet
        unmodSet.add("Hello");
    }
}
