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

package test.jdk.io;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.29, 4:52 PM
 */
public class TextFileReadingText {

    @Test
    public void test1() {

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
    public void test2() throws IOException {

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
    public void test3() throws FileNotFoundException {
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
    public void test4() throws FileNotFoundException {
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
