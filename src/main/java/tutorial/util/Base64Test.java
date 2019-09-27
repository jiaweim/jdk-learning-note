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

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import static org.testng.Assert.assertEquals;


/**
 *
 * @Class Base64Test
 * @author JiaweiM
 * @date Jun 30, 2015 10:15:57 AM
 */
public class Base64Test
{

    private Decoder decoder;
    private Encoder encoder;

    @BeforeClass
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
