/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 JiaweiMao
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */

/**
 * @version 1.00
 */

package test.jdk.io;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
