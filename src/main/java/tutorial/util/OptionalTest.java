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
package tutorial.util;


import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.*;


/**
 * @author JiaweiMao
 * @version 1.00
 * @date Jul 07 2016, 18:59
 */
public class OptionalTest
{

    @Test
    public void testEmpty()
    {

        Optional<String> optionalName = Optional.empty();
        assertFalse(optionalName.isPresent());
    }

    @Test
    public void testOf()
    {
        assertEquals("training", Optional.of("training").get());
    }

    @Test
    public void testOf_null()
    {
        try {
            Optional.of(null);
        } catch (NullPointerException expected) {
        }
    }

    @Test
    public void testOfNullable()
    {
        Optional<String> optionalName = Optional.ofNullable("bob");
        assertEquals("bob", optionalName.get());
    }

    @Test
    public void testOfNullable_null()
    {
        // not promised by spec, but easier to test
        assertSame(Optional.empty(), Optional.ofNullable(null));
    }

    @Test
    public void testIsPresent_no()
    {
        assertFalse(Optional.empty().isPresent());
    }

    @Test
    public void testIsPresent_yes()
    {
        assertTrue(Optional.of("training").isPresent());
    }

    @Test
    public void testGet_absent()
    {
        Optional<String> optional = Optional.empty();
        try {
            optional.get();
        } catch (IllegalStateException expected) {
        }
    }

    @Test
    public void testGet_present()
    {
        assertEquals("training", Optional.of("training").get());
    }
}
