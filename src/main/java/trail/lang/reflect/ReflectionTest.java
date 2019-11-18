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

package trail.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 
 * @author	JiaweiM
 * @date	Oct 24, 2015 11:55:28 AM
 */
public class ReflectionTest {
	
	public static void main(String[] args) {
		// read class name from command line args or user input
		String name;
		if(args.length > 0)
			name = args[0];
		else{
			Scanner in = new Scanner(System.in);
			System.out.println("Enter class name (e.g. java.util.Date):");
			name = in.next();
			try {
				// print class name and superclass name 
				Class cl = Class.forName(name);
				Class supercl = cl.getSuperclass();
				String modifiers = Modifier.toString(cl.getModifiers());
				if(modifiers.length() > 0)
					System.out.print(modifiers+" ");
				if(supercl != null && supercl != Object.class)
					System.out.print(" extends "+supercl.getName());
				
				System.out.print("\n{\n");
				printConstructors(cl);
				System.out.println();
				printMethods(cl);
				System.out.println();
				printFields(cl);
				System.out.println("}");
				
			} catch (Exception e) {
			}
			System.exit(0);
		}
	}
	
	/**
	 * Print all constructors of a class
	 * @param cl a class
	 */
	public static void printConstructors(Class cl){
		Constructor[] constructors = cl.getDeclaredConstructors();
		for(Constructor c: constructors){
			String name= c.getName();
			System.out.print(" ");
			String modifiers = Modifier.toString(c.getModifiers());
			if(modifiers.length() > 0)
				System.out.print(modifiers+" ");
			System.out.print(name+"(");
			
			// print parameter types
			Class[] paramTypes = c.getParameterTypes();
			for(int j=0; j< paramTypes.length; j++){
				if(j>0)
					System.out.print(",");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	/**
	 * Prints all methods of a class
	 * @param cl a class
	 */
	public static void printMethods(Class cl){
		Method[] methods = cl.getDeclaredMethods();
		for(Method m : methods){
			Class retType = m.getReturnType();
			String name = m.getName();
			
			System.out.print(" ");
			// print modifiers, return type and method name
			String modifiers = Modifier.toString(m.getModifiers());
			if(modifiers.length() > 0)
				System.out.print(modifiers+" ");
			System.out.print(retType.getName()+" "+name+"(");
			
			// print parameter types
			Class[] paramTypes = m.getParameterTypes();
			for(int j=0; j< paramTypes.length; j++){
				if(j>0)
					System.out.print(",");
				System.out.print(paramTypes[j].getName());
				System.out.println(");");
			}
		}
	}
	
	/**
	 * Prints all fields of a class
	 * @param cl a class
	 */
	public static void printFields(Class cl){
		Field[] fields = cl.getDeclaredFields();
		for(Field field : fields){
			Class type = field.getType();
			String name = field.getName();
			System.out.print(" ");
			String modifiers = Modifier.toString(field.getModifiers());
			if(modifiers.length() > 0)
				System.out.print(modifiers+" ");
			System.out.println(type.getName()+" "+name+";");
		}
	}

}
