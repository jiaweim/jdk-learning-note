/**********************************************************
  * File:MatcherFind.java
  *
  * Author:	Jiawei Mao                     
  *
  * Created on Jan 13, 2016
  *                       
  * Copyright (c) Dalian Institute of Chemical Physics
  *	Chinese Academy of Sciences
  * 
  * Contact: jiawei@dicp.ac.cn                   
  *                                              
  *******************************************************/
package test.jdk.util.regex;

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
