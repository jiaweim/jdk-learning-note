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
package tutorial.util.jar;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import static org.testng.Assert.assertEquals;


/**
 * @author JiaweiMao
 * @date Mar 12, 2016 4:32:59 PM
 */
public class JarFileTest
{

    JarFile jarFile;

    @BeforeClass
    public void setUp() throws IOException
    {
        jarFile = new JarFile("E:/JavaApp/GeneMapper.jar");
    }

    @AfterClass
    public void tearDown() throws IOException
    {
        jarFile.close();
    }

    @Test
    public void testManifest()
    {
        String manifestName = JarFile.MANIFEST_NAME;
        assertEquals("META-INF/MANIFEST.MF", manifestName);
    }

    @Test
    public void testCtr() throws IOException
    {
        jarFile = new JarFile("E:/FileFormat/jackson-annotations-2.5.0.jar");
        Properties prop = new Properties();
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry aEntry = entries.nextElement();
            if (aEntry.getName().contains("pom.properties")) {
                prop.load(jarFile.getInputStream(aEntry));
            }
        }
        String version = prop.getProperty("version");
        System.out.println(version);
    }
}
