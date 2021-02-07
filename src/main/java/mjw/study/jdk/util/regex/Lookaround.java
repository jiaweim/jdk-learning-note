package mjw.study.jdk.util.regex;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author JiaweiMao
 * @date Jan 5, 2016 10:35:34 AM
 */
class Lookaround
{
    @Test
    void lookahead()
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
    void lookhead2()
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
    void lookbehind()
    {
        assertFalse(Pattern.matches("[a-z](?<=b)", "ab"));
        assertTrue(Pattern.matches("[a-z](?<=b)", "b"));
    }
}
