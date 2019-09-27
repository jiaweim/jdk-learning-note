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

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;


/**
 *
 * @author JiaweiM
 * @date Nov 14, 2015 3:52:09 PM
 */
public class PrintStreamTest
{

    @Test
    public void testPrintf() throws FileNotFoundException
    {
        ByteArrayOutputStream baOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baOutputStream);
        ps.printf("%s! Welcome to use PrintStream!\n", "jiawei");
        ps.close();
        assertEquals("jiawei! Welcome to use PrintStream!\n", baOutputStream.toString());
    }
}
