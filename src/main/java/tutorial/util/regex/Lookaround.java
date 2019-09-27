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
package tutorial.util.regex;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

/**
 * @author JiaweiMao
 * @date Jan 5, 2016 10:35:34 AM
 */
public class Lookaround
{
    @Test
    public void lookahead()
    {
        String string = "by Jeffrey Friedl.";
        Pattern pattern = Pattern.compile("(?=Jeffrey)");
        Matcher matcher = pattern.matcher(string);

        assertTrue(matcher.find());
        assertEquals(3, matcher.start());
        assertEquals(3, matcher.end());
    }

    /**
     * 匹配以head开头的单词
     */
    @Test
    public void lookhead2()
    {
        String string = "Please put up your hand! Hey, handsome boy, I mean you."
                + "Don't forget to handle your problem.";
        Pattern pattern = Pattern.compile("\\b(?=hand)\\w+\\b");
        Matcher matcher = pattern.matcher(string);

        assertTrue(matcher.find());
        assertEquals("hand", matcher.group());
        assertEquals(19, matcher.start());
        assertEquals(23, matcher.end());

        assertTrue(matcher.find());
        assertEquals("handsome", matcher.group());
        assertEquals(30, matcher.start());
        assertEquals(38, matcher.end());
    }

    /**
     * 零宽断言，没有实际的匹配项，所以，不要认为(?<=b)会匹配一个b,实际只是
     * 限制前面的匹配，末尾需要有一个b。
     */
    @Test
    public void lookbehind()
    {
        assertFalse("", Pattern.matches("[a-z](?<=b)", "ab"));
        assertTrue(Pattern.matches("[a-z](?<=b)", "b"));
    }
}
