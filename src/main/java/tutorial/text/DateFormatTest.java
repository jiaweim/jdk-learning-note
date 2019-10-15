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

package tutorial.text;

import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author JiaweiM
 * @date Aug 13, 2015 10:58:20 AM
 */
public class DateFormatTest {

    @Test
    public void testToString(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        System.out.println(dateFormat.format(new Date()));
    }

    @Test
    public void testGetTimeInstance() {
        Date date = new Date();
        DateFormat df;

        df = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.JAPAN);
        System.out.println("Japan: " + df.format(date));

        df = DateFormat.getTimeInstance(DateFormat.LONG, Locale.UK);
        System.out.println("UK: " + df.format(date));

        df = DateFormat.getTimeInstance(DateFormat.LONG, Locale.CANADA);
        System.out.println("Canana: " + df.format(date));

        df = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CHINESE);
        System.out.println("Chinese: " + df.format(date));

    }

    @Test
    public void testGetDateInstance() {
        Date date = new Date();
        DateFormat df;

        //getDateInstance����һ��DateFormat���ʵ����Ը�ʽ��������Ϣ
        df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.JAPAN);
        System.out.println("Japan:" + df.format(date));

        df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.KOREA);
        System.out.println("Korea:" + df.format(date));

        df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.UK);
        System.out.println("UK:" + df.format(date));

        df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
        System.out.println("US:" + df.format(date));

        df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.CHINA);
        System.out.println("China:" + df.format(date));

        df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);
        System.out.println("China:" + df.format(date));

        df = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINA);
        System.out.println("China:" + df.format(date));

        df = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
        System.out.println("China:" + df.format(date));
    }
}
