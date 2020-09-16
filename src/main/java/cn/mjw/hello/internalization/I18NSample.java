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
package cn.mjw.hello.internalization;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author  JiaweiMao
 * @date	Jan 6, 2016 10:59:09 AM
 */
public class I18NSample {

	public static void main(String[] args) {
		String language;
		String country;
		if(args.length != 2){
			language = new String("en");
			country = new String("US");
		}else{
			language = new String(args[0]);
			country = new String(args[1]);
		}
		
		Locale currentLocale;
		ResourceBundle message;
		
		currentLocale = new Locale(language, country);
		message = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		System.out.println(message.getString("greetings"));
		System.out.println(message.getString("inquiry"));
		System.out.println(message.getString("farewell"));
	}
}
