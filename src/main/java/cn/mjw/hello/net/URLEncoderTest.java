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

package cn.mjw.hello.net;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 
 * @author JiaweiM
 * @date Jul 7, 2015 8:21:20 PM
 */
public class URLEncoderTest {

	public static void main(String[] args) {
		try {
			System.out.println(URLEncoder.encode("This string has spaces", "UTF-8"));
			System.out.println(URLEncoder.encode("This*string*has*asterisks", "UTF-8"));
			System.out.println(URLEncoder.encode("This%string%has%percent%signs", "UTF-8"));
			System.out.println(URLEncoder.encode("This+string+has+pluses", "UTF-8"));
			System.out.println(URLEncoder.encode("This/string/has/slashes", "UTF-8"));
			System.out.println(URLEncoder.encode("This\"string\"has\"quote\"marks", "UTF-8"));
			System.out.println(URLEncoder.encode("This:string:has:colons", "UTF-8"));
			System.out.println(URLEncoder.encode("This~string~has~tildes", "UTF-8"));
			System.out.println(URLEncoder.encode("This(string)has(parentheses)", "UTF-8"));
			System.out.println(URLEncoder.encode("This.string.has.periods", "UTF-8"));
			System.out.println(URLEncoder.encode("This=string=has=equals=signs", "UTF-8"));
			System.out.println(URLEncoder.encode("This&string&has&ersands", "UTF-8"));
			System.out.println(URLEncoder.encode("This��string��has�� non-ASCII characters", "UTF-8"));

		} catch (UnsupportedEncodingException ex) {
			throw new RuntimeException("Broken VM does not support UTF-8");
		}
	}
}
