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
package tutorial.nio;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;


/**
 * @author JiaweiMao
 * @date Mar 7, 2016 9:30:04 PM
 */
public class PathTest
{

    Path path;

    @BeforeClass
    public void setUp()
    {
        path = Paths.get("E:\\FileFormat\\C#\\compressedFile.txt");
    }

    @Test
    public void testGetFileName()
    {
        Path namePath = path.getFileName();
        assertEquals("compressedFile.txt", namePath.toString());
    }

    @Test
    public void testGetName()
    {
        Path name = path.getName(0);
        assertEquals("FileFormat", name.toString());
    }

    @Test
    public void testCtr1()
    {
        Path path = Paths.get("E:", "FileFormat", "C#", "compressedFile.txt");
        assertEquals("E:\\FileFormat\\C#\\compressedFile.txt", path.toString());
    }

    @Test
    public void testResolve()
    {
        // define the fixed path
        Path base = Paths.get("E:/FileFormat");
        // resolve 20131216-hela.mzML file
        Path path_1 = base.resolve("20131216-hela.mzML");
        assertEquals("E:\\FileFormat\\20131216-hela.mzML", path_1.toString());
        // resolve 20131216-hela.log.txt file
        Path path_2 = base.resolve("20131216-hela.log.txt");
        assertEquals("E:\\FileFormat\\20131216-hela.log.txt", path_2.toString());
    }

    @Test
    public void testResolveSibling()
    {
        // define the fixed path
        Path base = Paths.get("E:\\FileFormat\\20131216-hela.mzML");
        // resolve sibling 20131216-hela.PSMs.tsv file
        Path path = base.resolveSibling("20131216-hela.PSMs.tsv");
        assertEquals("E:\\FileFormat\\20131216-hela.PSMs.tsv", path.toString());
    }

    @Test
    public void testRelative()
    {
        Path path01 = Paths.get("BNP.txt");
        Path path02 = Paths.get("AEGON.txt");

        Path path01_to_path02 = path01.relativize(path02);
        assertEquals("..\\AEGON.txt", path01_to_path02.toString());
        Path path02_to_path01 = path02.relativize(path01);
        assertEquals("..\\BNP.txt", path02_to_path01.toString());
    }

    @Test
    public void testRelativize()
    {
        Path path01 = Paths.get("/tournaments/2009/BNP.txt");
        Path path02 = Paths.get("/tournaments/2011");

        Path path01_to_path02 = path01.relativize(path02);
        assertEquals("..\\..\\2011", path01_to_path02.toString());
        Path path02_to_path01 = path02.relativize(path01);
        assertEquals("..\\2009\\BNP.txt", path02_to_path01.toString());
    }
}
