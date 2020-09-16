package cn.mjw.hello.util;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author JiaweiMao
 * @version 1.00
 * @date Jul 07 2016, 18:59
 */
class OptionalTest
{
    @Test
    void testEmpty()
    {
        Optional<String> optionalName = Optional.empty();
        assertFalse(optionalName.isPresent());
    }

    @Test
    void testOf()
    {
        assertEquals("training", Optional.of("training").get());
    }

    @Test
    void testOf_null()
    {
        try {
            Optional.of(null);
        } catch (NullPointerException expected) {
        }
    }

    @Test
    void testOfNullable()
    {
        Optional<String> optionalName = Optional.ofNullable("bob");
        assertEquals("bob", optionalName.get());
    }

    @Test
    void testOfNullable_null()
    {
        // not promised by spec, but easier to test
        assertSame(Optional.empty(), Optional.ofNullable(null));
    }

    @Test
    void testIsPresent_no()
    {
        assertFalse(Optional.empty().isPresent());
    }

    @Test
    void testIsPresent_yes()
    {
        assertTrue(Optional.of("training").isPresent());
    }

    @Test
    void testGet_absent()
    {
        Optional<String> optional = Optional.empty();
        try {
            optional.get();
        } catch (IllegalStateException expected) {
        }
    }

    @Test
    void testGet_present()
    {
        assertEquals("training", Optional.of("training").get());
    }
}
