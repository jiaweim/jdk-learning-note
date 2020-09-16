package cn.mjw.hello.lang;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiMao
 * @version 1.00
 * @date Jun 14 2016, 21:24
 */
public class StringTest
{
    @Test
    public void testUpper()
    {
        String a = "hello";
        String b = "java";
        int len = a.length() + b.length();
        if (a.compareTo(b) > 0)
            System.out.println("Yes");
        else
            System.out.println("No");


        String s = a.substring(0, 1).toUpperCase() + a.substring(1) + " " + b.substring(0, 1).toUpperCase() + b.substring(1);
        System.out.println(s);
    }

    @Test
    public void sub()
    {
        String s = "Helloworld";
        int start = 3;
        int end = 7;
        System.out.println(s.substring(start, end));
    }

    public static String getSmallestAndLargest(String s, int k)
    {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        for (int i = 0; i <= s.length() - k; i++) {
            String substring = s.substring(i, i + k);
            if (smallest.isEmpty() || substring.compareTo(smallest) < 0)
                smallest = substring;
            if (substring.compareTo(largest) > 0)
                largest = substring;
        }

        return smallest + "\n" + largest;
    }

    @Test
    public void testSub()
    {
        String s = "welcometojava";
        int len = 3;
        System.out.println(getSmallestAndLargest(s, len));
    }

    @Test
    public void testPalindrome()
    {
        String s = "madam";
        String rev = new StringBuilder(s).reverse().toString();
        if (s.equals(rev))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    @Test
    public void testAnagrams()
    {
        String a = "anagram";
        String b = "anagram";
        char[] arraya = a.toLowerCase().toCharArray();
        char[] arrayb = b.toLowerCase().toCharArray();
        Arrays.sort(arraya);
        Arrays.sort(arrayb);
        boolean equals = Arrays.equals(arraya, arrayb);

    }

    @Test
    public void testToken()
    {
        String s = "He is a very very good boy, isn't he?";
        s = s.trim();
        if (s.length() == 0)
            System.out.println(0);
        else {
            String[] split = s.split("[ !,?._'@]+");
            System.out.println(split.length);
            for (String item : split) {
                System.out.println(item);
            }
        }
    }

    @Test
    public void testCompile()
    {
        try {
            Pattern compile = Pattern.compile("batcatpat(nat");
            System.out.println("Valid");
        } catch (Exception e) {
            System.out.println("Invalid");
        }
    }

    @Test
    public void testIP()
    {
        String s = "^(2[0-4]\\d|25[0-5]|1\\d\\d|0\\d\\d|\\d\\d?)(\\.(2[0-4]\\d|25[0-5]|1\\d\\d|0\\d\\d|\\d\\d?)){3}$";
        String a = "000.12.12.034";
        System.out.println(a.matches(s));
        System.out.println("121.234.12.12".matches(s));
    }

    @Test
    public void testToString()
    {
        Double value = null;
        System.out.println(value.toString());
    }

    @Test
    void testEquals()
    {
        String a = "String";
        String b = "String";

        System.out.println(a == b);
        System.out.println(a.equals(b));
    }

    @Test
    public void testPattern()
    {
        String pro = "XRHLAPTGNAPASRGLPTTTQRVGSECPDRLAMDFGGAGAAQQGLTDSCQSGGVPTAVQN" +
                "LAPRAAVAAAAPRAVAPYKYASSVRSPHPAIQPLQAPQPAVHVQGQEPLTASMLAAAPPQ" +
                "EQKQMLGERLFPLIQTMHSNLAGKITGMLLEIDNSELLHMLESPESLRSKVDEAVAVLQA" +
                "HHAKKEAAQKDSKAK";
        String pep = "IRHLAPTGNAPASR";
        String x = pro.replaceAll("X", "*");
        System.out.println(x);
    }

    /**
     * 常规类型、字符类型和数值类型格式化：%[index$][flags][width][.precision]conversion
     */
    @Test
    public void testFormat_Int()
    {
        assertEquals("-0003,123", String.format("%1$,09d", -3123));
        assertEquals("      -31", String.format("%1$9d", -31));
        assertEquals("-31      ", String.format("%1$-9d", -31));
        assertEquals("     (31)", String.format("%1$(9d", -31));
        assertEquals("   0x1639", String.format("%1$#9x", 5689));
    }

    @Test
    void testFormat_Double()
    {
        System.out.println(String.format("%4.4g", 65.3));

        assertEquals(String.format("%.4G", 0.0008E-8), "8.000E-12");
        System.out.println(String.format("%G", 0.00253));
    }

    @Test
    public void testFormat_percent()
    {
        System.out.println(String.format("%d%%", 12));
    }

    @Test
    void testFormat_Index()
    {
        String hello = String.format("%2$s", 21, "Hello");
        assertEquals(hello, "Hello");
    }


    @Test
    public void split()
    {
        String s = ">sp|Q8I6R7|ACN2_ACAGO Acanthoscurrin-2 (Fragment) OS=Acanthoscurria gomesiana GN=acantho2 PE=1 SV=1";
        String[] split = s.split("\\|");
        System.out.println(split.length);
    }

    @Test
    public void testSplit()
    {
        String string = "AGOAIGJ;AEGAG,AEGA";
        String[] strings = string.split("[;,]");
        assertEquals(3, strings.length);
        assertEquals("AGOAIGJ", strings[0]);
    }

    /**
     * 返回字符串的规范表示形式。
     * String私有维护一个字符串pool，当调用intern()时，若pool中包含该字符串，则从pool中返回该字符串。
     * 否则，添加该字符串到pool中，并返回该字符串的引用。
     */
    @Test
    void testIntern()
    {

    }

    @Test
    void testIndexOf()
    {
        String seq = "AOIDJGOAIYOGH";
        int idx = seq.indexOf("DJ");
        assertEquals(3, idx);
    }

    @Test
    void testCompareTo()
    {
        String arr[] = {"Now", "add", "ball", "collect", "directly", "epsilo"};
        for (int j = 0; j < arr.length; j++) {
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i].compareToIgnoreCase(arr[j]) < 0) {
                    String t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
            }
        }
    }

    @Test
    void testCompareNull()
    {
        String a = null;
        String b = "";
        System.out.println(a.compareTo(b));
    }

}
