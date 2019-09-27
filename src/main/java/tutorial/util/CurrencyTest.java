/*
 * Copyright 2018 JiaweiMao jiaweiM_philo@hotmail.com
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

package tutorial.util;

import org.testng.annotations.Test;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 15 May 2019, 9:31 PM
 */
public class CurrencyTest
{
    @Test
    public void test()
    {
        double pay = 12324.13;
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(formatter.format(pay));
        Locale locale = new Locale("en", "IN");
        formatter = NumberFormat.getCurrencyInstance(locale);
        System.out.println(formatter.format(pay));
        formatter = NumberFormat.getCurrencyInstance(Locale.CHINA);
        System.out.println(formatter.format(pay));
        formatter = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println(formatter.format(pay));

        for (Currency availableCurrency : Currency.getAvailableCurrencies()) {
            System.out.println(availableCurrency + "\t" + availableCurrency.getCurrencyCode() + "\t" + availableCurrency.getDisplayName());
        }

    }

    @Test
    public void create()
    {
        Locale locale = new Locale("inc", "IN");
    }
}
