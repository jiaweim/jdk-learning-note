package mjw.study.jdk.util.regex;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author JiaweiM
 * @date Dec 14, 2015 1:56:34 PM
 */
public class BoundaryMatch
{
    /**
     * ^$
     * 匹配字符串开头和结尾，如果启用MULTILINE模式，则匹配每行的开头和结尾。
     */
    @Test
    public void testLineBegin()
    {
        int startPos = 0, endPos = 70;
        String input = "Brooklyn Dodgers, National League, 1911, 1912, 1932-1957\n"
                + "Chicago Cubs, National League, 1903-present\n"
                + "Detroit Tigers, American League, 1901-present\n"
                + "New York Giants, National League, 1885-1957\n"
                + "Washington Senators, American League, 1901-1960\n";

        String pattern = "^((\\w+(\\s?)){2,}),\\s(\\w+\\s\\w+),(\\s\\d{4}(-(\\d{4}|present))?,?)+";
        Pattern pa = Pattern.compile(pattern);

        Matcher matcher;
        if (input.substring(startPos, endPos).contains(",")) {
            matcher = pa.matcher(input);
            while (matcher.find()) {
            }
        }
    }

}
