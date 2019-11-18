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
package trail.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author  JiaweiMao
 * @date	Jan 13, 2016 10:49:38 PM
 */
public class MatcherFind {
	
	public static void main(String[] args) {
		String seq = "AOSWIHGOSTOLSIDIOY";
		
		Pattern p = Pattern.compile("[STY]");
		Matcher matcher = p.matcher(seq);
		while(matcher.find()){
			System.out.print(matcher.start()+";");
		}
		System.out.println();
		
		matcher.reset(seq);
		int st = 0;
		while(matcher.find(st)){
			System.out.print(matcher.start()+",");
			st = matcher.start()+1;
		}
		System.out.println();
	}

}
