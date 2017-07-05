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

/**
 * One to read the binary file is to use the class FileInputStream class.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.29, 4:25 PM
 */
public class BinaryFileReadingTest {


    /**
     * The over all performance of the program is not good as it is just reading one byte at a time and then
     * writing to the output stream. The performance of the program can be increased if BufferedInputStream is used.
     *
     * @throws IOException
     */
    public void testv1() throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            //Open the input and out files for the streams
            fileInputStream = new FileInputStream("test.jpg");
            fileOutputStream = new FileOutputStream("test_copy.jpg");
            int data;

            //Read each byte and write it to the output file
            //value of -1 means end of file
            while ((data = fileInputStream.read()) != -1) {
                fileOutputStream.write(data);
            }
        } catch (IOException e) {
            //Display or throw the error
            System.out.println("Eorr while execting the program: " + e.getMessage());
        } finally {
            //Close the resources correctly
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileInputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    @Test
    public void testv2() throws IOException {
        InputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {

            //find the file size
            File fileHandle = new File("test.jpg");
            long length = fileHandle.length();

            //Open the input and out files for the streams
            fileInputStream = new BufferedInputStream(new FileInputStream("test.jpg"));
            fileOutputStream = new FileOutputStream("test_copy.jpg");
            int data;

            //Read data into buffer and then write to the output file
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            //Display or throw the error
            System.out.println("Eorr while execting the program: " + e.getMessage());
        } finally {
            //Close the resources correctly
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileInputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    /**
     * The advantage of using the try-with-resources is that it automatically closes the opened streams with the
     * execution of code block ends. So, this a good news for the programmers as the resources are automatically handled
     * in a better way.
     *
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {

        //find the file size
        File fileHandle = new File("test.jpg");
        long length = fileHandle.length();

        try (
                //Open the input and out files for the streams
                InputStream fileInputStream = new BufferedInputStream(new FileInputStream("test.jpg"));
                FileOutputStream fileOutputStream = new FileOutputStream("test_copy.jpg");
        ) {
            int data;
            //Read data into buffer and then write to the output file
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

        }//try-with-resource
    }

}
