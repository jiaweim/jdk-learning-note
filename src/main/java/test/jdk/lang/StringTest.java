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

package test.jdk.lang;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiMao
 * @version 1.00
 * @date Jun 14 2016, 21:24
 */
public class StringTest {

    @Test
    public void testPattern(){

        String  pro = "XRHLAPTGNAPASRGLPTTTQRVGSECPDRLAMDFGGAGAAQQGLTDSCQSGGVPTAVQN" +
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
    public void testFormat() {


    }


    @Test
    public void split(){
        String s= ">sp|Q8I6R7|ACN2_ACAGO Acanthoscurrin-2 (Fragment) OS=Acanthoscurria gomesiana GN=acantho2 PE=1 SV=1";
        String[] split = s.split("\\|");
        System.out.println(split.length);

    }

    @Test
    public void testSplit() {

        String string = "AGOAIGJ;AEGAG,AEGA";
        String[] strings = string.split("[;,]");
        System.out.println(strings.length);
        System.out.println(strings[0]);
    }

    /**
     * 返回字符串的规范表示形式。
     * String私有维护一个字符串pool，当调用intern()时，若pool中包含该字符串，则从pool中返回该字符串。
     * 否则，添加该字符串到pool中，并返回该字符串的引用。
     */
    @Test
    public void testIntern() {

    }

    @Test
    public void testIndexOf() {
        String seq = "AOIDJGOAIYOGH";
        int idx = seq.indexOf("DJ");
        assertEquals(3, idx);
    }

    @Test
    public void testCompareTo() {
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

}
