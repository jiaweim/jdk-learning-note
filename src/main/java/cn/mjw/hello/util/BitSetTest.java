package cn.mjw.hello.util;

import org.junit.jupiter.api.Test;

import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author JiaweiMao
 * @date Jan 16, 2016 8:19:09 PM
 */
class BitSetTest
{
    /**
     * 查看一个字符串中用到了哪些字符。
     */
    @Test
    void test()
    {
        BitSet bitSet = new BitSet();

        String string = "AOWJGTOAHNGOAIETOAJGOIAHIOAOIUT9OWUEGOLAJH";
        for (int i = 0; i < string.length(); i++)
            bitSet.set(string.charAt(i));

        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bitSet.size(); i++) {
            if (bitSet.get(i))
                sBuffer.append((char) i);
        }
        assertEquals("9AEGHIJLNOTUW", sBuffer.toString());
    }

    /**
     * 如数据source=[3,5,6,9]
     * 用int，就需要4*4个字节
     * 存储大量数据，基本原理：
     * 1. 找出数据中最大值(对整数位maxvalue=9)
     * 2. 声明一个BitSet bs，size为为maxValue+1=10
     * 3. 遍历源数据source,bs[source[i]]设置为true。
     * 最后的值为：
     * bs[0,0,0,1,0,1,1,0,0,1]
     * 这样原本int型需要4字节共32位的数，现在只用了1位，比例32:1.
     */
    @Test
    void test2()
    {
        BitSet bm = new BitSet();
        assertTrue(bm.isEmpty());
        // default size
        assertEquals(64, bm.size());
    }
}
