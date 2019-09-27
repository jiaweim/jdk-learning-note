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

package tutorial.io;



import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;

import static org.testng.Assert.assertEquals;


/**
 * @author JiaweiM
 * @date Sep 19, 2015 8:57:44 AM
 */
public class ScannerTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // get first input

        int a;
        int b;
        while (scanner.hasNextInt()) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            System.out.println(a + b);
        }

        scanner.close();
//        System.out.print("What is your name? ");
//        String name = scanner.nextLine();
//        // get second input
//        System.out.print("How old are you? ");
//        int age = scanner.nextInt();
//
//        // display output on console
//        System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));
    }

    @Test
    public void testFindInLine() {
        String input = "1 fish 2 fish red fish blue fish";
        Scanner s = new Scanner(input);
        s.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
        MatchResult result = s.match();
        assertEquals("1", result.group(1));
        assertEquals("2", result.group(2));
        assertEquals("red", result.group(3));
        assertEquals("blue", result.group(4));
        s.close();
    }

    @Test
    public void testString() {
        String input = "1 fish 2 fish red fish blue fish";
        Scanner s = new Scanner(input);
        s.useDelimiter("\\s*fish\\s*");
        assertEquals(1, s.nextInt());
        assertEquals(2, s.nextInt());
        assertEquals("red", s.next());
        assertEquals("blue", s.next());
        s.close();
    }


    @Test
    public void testFile() throws FileNotFoundException {

        File fileToRead = new File(ScannerTest.class.getResource("afile").getPath());

        List<Integer> integers = new ArrayList<Integer>();

        Scanner fileScanner = new Scanner(fileToRead);

        fileScanner.nextLine();

        fileScanner.useDelimiter("\\.[ ]+");

        while (fileScanner.hasNextLine()) {
            fileScanner.nextLine();
            while (fileScanner.hasNextInt()) {
                integers.add(fileScanner.nextInt());
            }
        }
        System.out.println("Arraylist contains: " + integers.toString());

        fileScanner.close();
    }

}
