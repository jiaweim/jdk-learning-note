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
 * 
 * @version 1.00
 */

package tutorial.util;

import org.testng.annotations.Test;

import java.text.DateFormat;
import java.util.Locale;

import static org.testng.Assert.assertEquals;


/**
 * Locale用处有限，唯一有用的是那些标识语言和国家代码的方法，其中最重要的是Locale#getdisplayName，
 * 返回一个描述Locale的字符串。
 * 
 * @author	JiaweiM
 * @date	Aug 13, 2015 11:22:50 AM
 */
public class LocaleTest {
	
	/**
	 * Construct with language
	 */
	@Test
	public void testCtr(){
		
		Locale locale = new Locale("de");
		assertEquals("", locale.getCountry());
		assertEquals("de", locale.getLanguage());
	}
	
	
	/**
	 * 返回本地操作系统的默认Locale, 可以调用setDefault 改变默认的Locale,这种
	 * 改变只对当前程序有效，不影响系统。
	 */
	@Test	
	public void testGetDefault(){
		Locale[] supportLocales = DateFormat.getAvailableLocales();
		for(int i=0; i<supportLocales.length; i++){
			Locale la = supportLocales[i];
//			System.out.println(la.getDisplayName());
		}
	}
}
