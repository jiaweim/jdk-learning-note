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

import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author JiaweiM
 * @date Dec 14, 2015 10:39:53 AM
 */
public class MatcherTest
{

    /**
     * start() 和 end()，对应匹配在文本中的起始和结束为止
     */
    @Test
    void testStartEnd()
    {
        String regex = "\\bcat\\b";
        String input = "cat cat cat cattie cat";

        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(input);

        int[] starts = new int[]{0, 4, 8, 19};
        int[] ends = new int[]{3, 7, 11, 22};

        int count = 0;
        while (matcher.find()) {
            assertEquals(starts[count], matcher.start());
            assertEquals(ends[count], matcher.end());
            count++;
        }
    }

    /**
     * 和replaceAll比较，可以自定义替换过程，比如，替换部分字符串。
     */
    @Test
    public void testAppendReplacement()
    {
        String regex = "a*b";
        String input = "aabfooaabfooabfoobhj";
        String replace = "-";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        StringBuffer sb = new StringBuffer();

        assertTrue(m.find());
        m.appendReplacement(sb, replace);
        assertEquals("-", sb.toString());

        assertTrue(m.find());
        m.appendReplacement(sb, replace);
        assertEquals("-foo-", sb.toString());

        assertTrue(m.find());
        m.appendReplacement(sb, replace);
        assertEquals("-foo-foo-", sb.toString());

        assertTrue(m.find());
        m.appendReplacement(sb, replace);
        assertEquals("-foo-foo-foo-", sb.toString());

        assertFalse(m.find());

        m.appendTail(sb);
        assertEquals("-foo-foo-foo-hj", sb.toString());
    }

    /**
     * 替换所有匹配项
     */
    @Test
    void testReplaceAll()
    {
        String regex = "dog";
        String input = "The dog says meow. All dogs say meow.";
        String replace = "cat";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        input = m.replaceAll(replace);

        assertEquals("The cat says meow. All cats say meow.", input);
    }

    /**
     * remove line termination characters from a string
     */
    @Test
    public void testReplaceAll2()
    {
        String input = "This is the original String." + System.getProperty("line.separator")
                + "This will be converted to a single line.";

        String regex = "\r?\n";
        String replce = " ";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        input = matcher.replaceAll(replce);
        assertEquals("This is the original String. This will be converted to a single line.", input);
    }

    /**
     * 要求字符串前面部分匹配，不用匹配整个字符串
     */
    @Test
    public void testLookingAt()
    {
        Pattern pattern = Pattern.compile("J2SE");

        String str1 = "J2SE is the only one for me";
        String str2 = "For me, it's J2SE, or nothing at all";
        String str3 = "J2SEistheonlyoneforme";

        Matcher matcher = pattern.matcher(str1);
        assertTrue(matcher.lookingAt());

        matcher.reset(str2);
        assertFalse(matcher.lookingAt());

        matcher.reset(str3);
        assertTrue(matcher.lookingAt());
    }

    /**
     * 要求匹配整个字符串
     */
    @Test
    public void testMatches()
    {
        String regex = "test";
        Pattern pattern = Pattern.compile(regex);

        String input = "this fails";

        Matcher matcher = pattern.matcher(input);
        assertFalse(matcher.matches());

        input = "this passes the test";
        matcher.reset(input);
        assertFalse(matcher.matches());

        input = "test";
        matcher.reset(input);
        assertTrue(matcher.matches());

        input = "test2";
        matcher.reset(input);
        assertFalse(matcher.matches());
    }

}
