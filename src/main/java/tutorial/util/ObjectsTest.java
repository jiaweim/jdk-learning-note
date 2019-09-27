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

import java.util.Objects;

import static org.testng.Assert.*;

/**
 *
 * @author JiaweiM
 * @date Sep 18, 2015 2:04:31 PM
 */
public class ObjectsTest
{

    @Test
    public void testEqual() throws Exception
    {
        assertTrue(Objects.equals(1, 1));
        assertTrue(Objects.equals(null, null));

        String s1 = "foobar";
        String s2 = new String(s1);

        assertTrue(Objects.equals(s1, s2));
        assertFalse(Objects.equals(s1, null));
        assertFalse(Objects.equals(null, s1));
        assertFalse(Objects.equals("foo", "bar"));
        assertFalse(Objects.equals("1", 1));
    }

    @Test
    public void testHashCode() throws Exception
    {
        int h1 = Objects.hash(1, "two", 3.0);
        int h2 = Objects.hash(new Integer(1), new String("two"), new Double(3.0));
        // repeatable
        assertEquals(h1, h2);

        // These don't strictly need to be true, but they're nice properties.
        assertTrue(Objects.hash(1, 2, null) != Objects.hash(1, 2));
        assertTrue(Objects.hash(1, 2, null) != Objects.hash(1, null, 2));
        assertTrue(Objects.hash(1, null, 2) != Objects.hash(1, 2));
        assertTrue(Objects.hash(1, 2, 3) != Objects.hash(3, 2, 1));
        assertTrue(Objects.hash(1, 2, 3) != Objects.hash(2, 3, 1));
    }

}
