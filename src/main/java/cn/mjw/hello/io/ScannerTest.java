package cn.mjw.hello.io;

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
class ScannerTest
{
    public static void main(String[] args)
    {

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
    void testFindInLine()
    {
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
    void testString()
    {
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
    void testFile() throws FileNotFoundException
    {
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
