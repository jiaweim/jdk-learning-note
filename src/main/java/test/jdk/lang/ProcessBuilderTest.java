/**********************************************************
  * File:ProcessBuilderTest.java
  *
  * Author:	Jiawei Mao                     
  *
  * Created on Jul 9, 2015
  *                       
  * Copyright (c) Dalian Institute of Chemical Physics
  *	Chinese Academy of Sciences
  * 
  * Contact: jiawei@dicp.ac.cn                   
  *                                              
  *******************************************************/

/**
 * 
 * @version 1.00
 */

package test.jdk.lang;

import java.io.IOException;

/**
 * 
 * @Class	ProcessBuilderTest
 * @author	JiaweiM
 * @date	Jul 9, 2015 3:50:03 PM
 */
public class ProcessBuilderTest {
	
	public static void main(String[] args) throws IOException, InterruptedException{
		ProcessBuilder pb = new ProcessBuilder("echo","This is ProcessBuilder Example");
		System.out.println("Run echo command");
		Process process = pb.start();
		int errCode = process.waitFor();
		System.out.println("Echo command executed, any errors? ");
	}

}
