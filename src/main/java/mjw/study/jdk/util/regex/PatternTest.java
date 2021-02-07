package mjw.study.jdk.util.regex;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.24, 2:21 PM
 */
class PatternTest
{

    @Test
    void test1()
    {
        String test = "Carbamidomethyl (C)";
        String regex = "^(.*)\\s\\((\\w*)\\)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(test);
        assertTrue(matcher.matches());

        assertEquals("Carbamidomethyl", matcher.group(1));
        assertEquals("C", matcher.group(2));
    }

    @Test
    void test2()
    {
        String test = "0.0007000.0";
        String regex = "^(\\d)\\.(\\d+)\\.(\\d)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(test);

        System.out.println(matcher.matches());
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        System.out.println(matcher.group(3));
    }


    /**
     * matches静态方法，可用于快速检测给定正则表达式是否在字符串中出现
     */
    @Test
    void testMatches()
    {
        boolean value = Pattern.matches("\\d", "1");
        assertTrue(value);
    }

    @Test
    void testSplit()
    {
        // 简单例子，单纯的字符串常量作为正则表达式
        String regex = ":";
        String input = "one:two:three:four:five";
        Pattern p = Pattern.compile(regex);
        String[] items = p.split(input);
        assertEquals("[one, two, three, four, five]", Arrays.toString(items));

        // 稍微复杂，使用其他正则表达式
        regex = "\\d";
        input = "one9two4three7four1five";
        p = Pattern.compile(regex);
        items = p.split(input);
        assertEquals("[one, two, three, four, five]", Arrays.toString(items));
    }

    /**
     * 返回给定字符的literal pattern字符串，得到的字符串可用于创建Pattern匹配该字符串，原字符串中的
     * 元字符和转义字符均为literal 含义，无额外意义。
     * 基本就是用\Q和\E将字符串括起来。
     */
    @Test
    void testQuote()
    {
        String input = "aoiejgoier";
        assertEquals("\\Qaoiejgoier\\E", Pattern.quote(input));
    }

    @Test
    void testFlags()
    {
        String regex = "abc$";
        String input = "Abc\ndef";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        assertFalse(matcher.find());

        pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        matcher = pattern.matcher(input);
        assertTrue(matcher.find());
    }

}
