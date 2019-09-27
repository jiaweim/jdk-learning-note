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

package tutorial.util.regex;

import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.*;


/**
 *
 * @author JiaweiM
 * @date Dec 14, 2015 2:02:48 PM
 */
public class GreedyMatch
{

    private static String greedyRegex = ".*foo";
    private static String reluctantRegex = ".*?foo";
    private static String possessiveRegex = ".*+foo";
    private static String input = "xfooxxxxxxfoo";

    @Test
    public void testGreedy()
    {
        Pattern pattern = Pattern.compile(greedyRegex);
        Matcher matcher = pattern.matcher(input);
        assertTrue(matcher.find());
        assertEquals("xfooxxxxxxfoo", matcher.group());

        assertEquals(0, matcher.start());
        assertEquals(13, matcher.end());
    }

    @Test
    public void testReluctant()
    {
        Pattern pattern = Pattern.compile(reluctantRegex);
        Matcher matcher = pattern.matcher(input);

        assertTrue(matcher.find());
        assertEquals("xfoo", matcher.group());
        assertEquals(0, matcher.start());
        assertEquals(4, matcher.end());

        assertTrue(matcher.find());
        assertEquals("xxxxxxfoo", matcher.group());
        assertEquals(4, matcher.start());
        assertEquals(13, matcher.end());

        assertFalse(matcher.find());
    }

    /**
     * .*+foo 由于是possessive模式，所以前面.*+就匹配完了前面所有的字符串，余下foo无字符串可匹配，所以
     * 无法匹配成功。
     */
    @Test
    public void testPossessive()
    {
        Pattern pattern = Pattern.compile(possessiveRegex);
        Matcher matcher = pattern.matcher(input);

        assertFalse(matcher.find());
    }
}
