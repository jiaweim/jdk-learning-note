package cn.mjw.hello.io;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.29, 4:52 PM
 */
class TextFileReadingText
{
    @Test
    void test1()
    {
        try {
            //Open input stream for reading the text file MyTextFile.txt
            InputStream is = new FileInputStream("data.txt");

            // create new input stream reader
            InputStreamReader instrm = new InputStreamReader(is);

            // Create the object of BufferedReader object
            BufferedReader br = new BufferedReader(instrm);

            String strLine;

            // Read one line at a time
            while ((strLine = br.readLine()) != null) {
                // Print line
                System.out.println(strLine);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void test2() throws IOException
    {
        try (
                //Open input stream for reading the text file MyTextFile.txt
                InputStream is = new FileInputStream("data.txt");

                // create new input stream reader
                InputStreamReader instrm = new InputStreamReader(is);

                // Create the object of BufferedReader object
                BufferedReader br = new BufferedReader(instrm);

        ) {
            String strLine;
            // Read one line at a time
            while ((strLine = br.readLine()) != null) {
                // Print line
                System.out.println(strLine);
            }

        }
    }

    /**
     * use Scanner to read large text file
     */
    @Test
    void test3() throws FileNotFoundException
    {
        //Create the file object
        File fileObj = new File("data.txt");

        //Scanner object for reading the file
        Scanner scnr = new Scanner(fileObj);

        //Reading each line of file using Scanner class
        while (scnr.hasNextLine()) {
            String strLine = scnr.nextLine();
            //print data on console
            System.out.println(strLine);
        }
    }

    /**
     * use Java 7 try-with=resources feature for Scanner
     */
    @Test
    void test4() throws FileNotFoundException
    {
        //Create the file object
        File fileObj = new File("data.txt");
        try (
                //Scanner object for reading the file
                Scanner scnr = new Scanner(fileObj);
        ) {
            //Reading each line of file using Scanner class
            while (scnr.hasNextLine()) {
                String strLine = scnr.nextLine();
                //print data on console
                System.out.println(strLine);
            }
        }
    }

}
