package cn.mjw.hello.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiM
 * @Class Base64Test
 * @date Jun 30, 2015 10:15:57 AM
 */
public class Base64Test
{

    private Decoder decoder;
    private Encoder encoder;

    @BeforeAll
    public void Setup()
    {
        decoder = Base64.getDecoder();
        encoder = Base64.getEncoder();
    }

    @Test
    public void test()
    {
        String input = "Man is distinguished, not only by his reason, but by this singular passion "
                + "from other animals, which is a lust of the mind, that by a perseverance of "
                + "delight in the continued and indefatigable generation of knowledge, exceeds "
                + "the short vehemence of any carnal pleasure.";

        String expected = "TWFuIGlzIGRpc3Rpbmd1aXNoZWQsIG5vdCBvbmx5IGJ5IGhpcyByZWFzb24sIGJ1dCBieSB0aGlz"
                + "IHNpbmd1bGFyIHBhc3Npb24gZnJvbSBvdGhlciBhbmltYWxzLCB3aGljaCBpcyBhIGx1c3Qgb2Yg"
                + "dGhlIG1pbmQsIHRoYXQgYnkgYSBwZXJzZXZlcmFuY2Ugb2YgZGVsaWdodCBpbiB0aGUgY29udGlu"
                + "dWVkIGFuZCBpbmRlZmF0aWdhYmxlIGdlbmVyYXRpb24gb2Yga25vd2xlZGdlLCBleGNlZWRzIHRo"
                + "ZSBzaG9ydCB2ZWhlbWVuY2Ugb2YgYW55IGNhcm5hbCBwbGVhc3VyZS4=";

        byte[] out = decoder.decode(expected.getBytes());
        assertEquals(input, new String(out));
    }

    /**
     * Just the same size
     */
    @Test
    public void test2()
    {
        String input = "Man";
        assertEquals("TWFu", encoder.encodeToString(input.getBytes()));
    }

    @Test
    public void testNot3()
    {
        String input = "A";
        assertEquals("QQ==", encoder.encodeToString(input.getBytes()));
    }

    @Test
    public void TestNot31()
    {
        String input = "BC";
        System.out.println(encoder.encodeToString(input.getBytes()));
    }

}
