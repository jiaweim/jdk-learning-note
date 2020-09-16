package cn.mjw.hello.util.regex;


import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 捕获组: (表达式) 使用括号的捕获按正则表达式中左括号的顺序从左到右自动编号。编号为零的是整个正则表达式匹配的文本。 有四种方法访问捕获的组：
 * <ul>
 * <li>使用反向引用。使用语法<code>\n</code>，在同一表达式中引用匹配的子表达式， 其中数字是捕获的表达式的初始数字。</li>
 * <li>使用命名反向引用。<code>\k name</code></li>
 * <li>使用$编号</li>
 * <li>通过编程方式</li>
 * </ul>
 * <p>
 * 实例：捕获重复单词。 (\w+)\s(\1) \w+，匹配一个或多个单词字符。第一个捕获组 \s，空白字符
 * (\1),与第一个捕获组中的字符匹配。这是第二个捕获组。
 *
 * @author JiaweiM
 * @date Dec 14, 2015 10:23:00 AM
 */
class GroupTest
{
    @Test
    void testGroup()
    {
        String str = "Hello,World! in Java.";
        Pattern pattern = Pattern.compile("W(or)(ld!)");
        Matcher matcher = pattern.matcher(str);
        // 执行第一次匹配
        boolean match = matcher.find();
        assertTrue(match);
        // group 0表示整个匹配
        assertEquals("World!", matcher.group(0));
        // 得到第一组匹配——与(or)匹配
        assertEquals("or", matcher.group(1));
        // 得到第二组匹配——与(ld!)匹配的，组也就是子表达式
        assertEquals("ld!", matcher.group(2));

        // 总匹配的索引起始位置
        assertEquals(6, matcher.start(0));
        assertEquals(6, matcher.start());

        // 总匹配索引的结束位置
        assertEquals(12, matcher.end(0));
        assertEquals(12, matcher.end());

        assertEquals(7, matcher.start(1));
        assertEquals(9, matcher.end(1));

        assertEquals(9, matcher.start(2));
        assertEquals(12, matcher.end(2));
    }


    /**
     * 捕获组
     * 命名匹配的子表达式：
     * (?<name>subexpression)
     * 或
     * (?'name' subexpression)
     * 名称不能包含标点符号[a-z][A-Z][0-9]</br>
     * 访问已命名的捕获组：
     * <ul>
     * <li>命名反向引用。\k<名称></li>
     * <li>反向引用。\n</li>
     * <li>在replaceAll中使用使用${名称}</li>
     * </ul>
     * <p>
     * 实例：
     * (?<duplicateWord>\w+)\s\k<duplicateWord>\W(?<nextWord>\w+)
     * (?<duplicateWord>\w+),匹配一个或多个字符。命名为duplicateWord
     * \s, 空白字符
     * \k<duplicateWord>, 匹配名为duplicateWord的捕获组
     */
    @Test
    void groupName()
    {
        String pattern = "(?<duplicateWord>\\w+)\\s\\k<duplicateWord>\\W(?<nextWord>\\w+)";
    }

    /**
     * 非捕获组：放在括号内，但是不放在分组内。
     * (?:subexpression)
     * 由正则表达式匹配的字符串不捕获。
     * <p>
     * 正则表达式：
     * (?:\b(?:\w+)\W*)+\.
     * 匹配由句号终止的语句。因为
     * (?:w+)匹配一个或多个单词字符。不将匹配度文本分给捕获的组。
     * \W*匹配零个或多个非单词字符
     * (?:\b(?:\w+)\W*)+ 一次或多次匹配单词后面跟零个或多个非单词字符，不讲匹配文本分配给捕获的组
     * \. 匹配句点
     */
    @Test
    void testNonGroup()
    {
        String pa = "(?:\\b(?:\\w+)\\W*)+\\.";
        String input = "This is a short sentence.";
        Matcher matcher = Pattern.compile(pa).matcher(input);
        assertTrue(matcher.matches());
        assertEquals("This is a short sentence.", matcher.group());
        assertEquals(0, matcher.groupCount());
    }

    /**
     * 非捕获组
     * 零宽度正预测先行断言：
     * (?= subexpression)
     * 通常，零宽度正预测先行断言用在正则表达式末尾。它定义了一个字符串，该子字符串必须出现在
     * 匹配字符串的末尾，但又不能包含在匹配结果中。这有助于预防过度回溯。可用于零宽度正预测
     * 先行断言来确保
     * <p>
     * \b\w+(?=\sis\b)
     * \b, 匹配单词边界
     * (?=\sis\b)确定单词后面为空白和单词 "is"。
     */
    @Test
    public void testZeroWidthPositiveLookaheadAssertion()
    {
        String pattern = "\\b\\w+(?=\\sis\\b)";
        String[] inputs = {"The dog is a Malamute.",
                "The island has beautiful birds.",
                "The pitch missed home plate.",
                "Sunday is a weekend day."};

        Pattern pa = Pattern.compile(pattern);
        int i = 0;
        String[] mas = {"dog", "Sunday"};
        for (String input : inputs) {
            Matcher match = pa.matcher(input);
            while (match.find()) {
                assertEquals(mas[i], match.group());
                i++;
            }
        }

    }

    /**
     * 非捕获组
     * 零宽度正回顾后发断言(zero-width positive lookbehind assertion):</br>
     * ?<= subexpression
     * 若要匹配成功，则subexpression必须在输入字符串当前位置的左侧，虽然该子字符串不会出现在匹配
     * 结果中。
     * 零宽度正预测后发断言通常在正则表达式的开头使用。它们定义了匹配的前提条件，但它不是匹配结果的一部分。
     * <p>
     * 实例：匹配二十一世纪年份的最后两个数字(数字"20"要在匹配的字符串之前)
     * (?<=\b20)\d{2}\b:
     * \d{2}匹配两个十进制数字
     * (?<=\b20)如果两个十进制数字的字边界以数字"20"开头，则继续匹配
     */
    @Test
    void zeroWidthPoitiveLookbehindAssertion()
    {
        String input = "2010 1999 1861 2140 2009";
        String patter = "(?<=\\b20)\\d{2}\\b";

        String[] match = {"10", "09"};
        Pattern pa = Pattern.compile(patter);
        Matcher ma = pa.matcher(input);
        int i = 0;
        while (ma.find()) {
            assertEquals(match[i], ma.group());
            i++;
        }
    }
}
