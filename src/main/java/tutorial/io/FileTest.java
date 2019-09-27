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

package tutorial.io;


import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date Jul 19 2016, 10:31
 */
public class FileTest
{

    public void testFilter()
    {
        File file = new File("E:\\data\\donghao");

        File[] files = file.listFiles((dir, name) -> name.endsWith(".csv"));
        for (File file1 : files) {
            System.out.println(file1.getName());
        }

    }

    @Test
    public void testCreateTempFile() throws IOException
    {
        // creates temporary file
        // prefix, suffix, directory
        File f = File.createTempFile("tmp", ".txt", new File("E:\\test"));

        // prints absolute path
        System.out.println("File path: " + f.getAbsolutePath());

        // deletes file when the virtual machine terminate
        f.deleteOnExit();

        // creates temporary file, if suffix is null, "tmp" is used.
        f = File.createTempFile("tmp", null, new File("D:/"));

        // prints absolute path
        System.out.print("File path: " + f.getAbsolutePath());

        // deletes file when the virtual machine terminate
        f.deleteOnExit();

        // if the directory is null, default temp folder is used (AppData\Local\Temp for Windows)
        f = File.createTempFile("tmp", null, null);
        System.out.println(f.getAbsolutePath());
        f.deleteOnExit();
    }

    /**
     * 测试用于程序是否可以执行此抽象路径名表示的文件
     */
    @Test
    public void testCanExecute()
    {
        File f = new File("C:\\Windows");
        assertTrue(f.canExecute());
        f = new File("C:\\xx");
        assertFalse(f.canExecute());
    }

    /**
     * 文件存在，并可以读取
     */
    @Test
    public void testCanRead()
    {
        File f = new File("C:\\Windows");
        assertTrue(f.canRead());
        f = new File("C:\\xx");
        assertFalse(f.canRead());
    }

    @Test
    public void testCanWrite()
    {
        File f = new File("C:\\Windows");
        assertTrue(f.canWrite());
        f = new File("C:\\xx");
        assertFalse(f.canWrite());
    }

    @Test
    void testSetReadOnly()
    {
        File f = new File("E:\\data\\liuzheyi\\fragment\\s1.mgf");
        assertTrue(f.setReadOnly());
        assertFalse(f.canWrite());
    }

    @Test
    void getName()
    {
        File f = new File("E:\\data\\liuzheyi\\fragment\\s1.mgf");
        assertEquals("s1.mgf", f.getName());
    }

    @Test
    public void separator()
    {

        String file = "E:\\data\\test\\phos" + File.separator + "F007707.csv";

        System.out.println(new File(file).exists());

    }
}
