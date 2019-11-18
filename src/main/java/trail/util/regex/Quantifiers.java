package trail.util.regex;


import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiM
 * @date Dec 14, 2015 1:55:28 PM
 */
public class Quantifiers
{
    /**
     * '*'零次或多次，等效于{0,}
     * \b,单词边界
     * 91*,9后面跟零或多个1
     * 9*,零个或多个9
     */
    @Test
    public void star()
    {
        String pattern = "\\b91*9*\\b";
        String input = "99 95 919 929 9119 9219 999 9919 91119";

        String[] match = {"99", "919", "9119", "999", "91119"};
        int[] idx = {0, 6, 14, 24, 33};

        Pattern pa = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pa.matcher(input);
        int i = 0;
        while (matcher.find()) {
            assertEquals(match[i], matcher.group());
            assertEquals(idx[i], matcher.start());
            i++;
        }
    }

    /**
     * '+'匹配一次或多次，等效于{1,}.对应的惰性限定符是+?。
     * <p>
     * 实例：\ban+\w*?\b， 匹配以字母a开头，且后跟一个或多个n的单词。
     */
    @Test
    public void plus()
    {
        String pattern = "\\ban+\\w*?\\b";
        String input = "Autumn is a great time for an annual announcement to all antique collectors.";

        String[] mas = {"an", "annual", "announcement", "antique"};
        int[] idx = {27, 30, 37, 57};

        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher ma = p.matcher(input);
        int mi = 0;
        while (ma.find()) {
            assertEquals(mas[mi], ma.group());
            assertEquals(idx[mi], ma.start());
            mi++;
        }
    }

    /**
     * '?' 匹配前面的元素零次或一次。等效于{0,1}。?是贪婪限定符，对应的惰性限定符是??。
     * 实例：\ban?\b匹配以字母a开头，后跟零个或零个n的单词，即匹配a和an。
     */
    @Test
    public void question()
    {
        String pattern = "\\ban?\\b";
        String input = "An amiable animal with a large snount and an animated nose.";

        String[] mas = {"An", "a", "an"};
        int[] idx = {0, 23, 42};
        Pattern pa = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher ma = pa.matcher(input);

        int i = 0;
        while (ma.find()) {
            assertEquals(mas[i], ma.group());
            assertEquals(idx[i], ma.start());
            i++;
        }
    }

}
