/*
 * Copyright 2018 JiaweiMao jiaweiM_philo@hotmail.com
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

import org.testng.annotations.Test;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 05 Oct 2019, 1:24 PM
 */
public class PathMatcherTest {

    @Test
    public void testMatch() {
        PathMatcher pm = FileSystems.getDefault().getPathMatcher("glob:*.java");
        assertTrue(pm.matches(Paths.get("PathMatcherDemo.java")));
        assertFalse(pm.matches(Paths.get("PathMatcherDemo.txt")));

        pm = FileSystems.getDefault().getPathMatcher("regex:([^\\s]+(\\.(?i)(png|jpg))$)");
        assertTrue(pm.matches(Paths.get("figure.jpg")));
        assertTrue(pm.matches(Paths.get("figure.png")));
        assertFalse(pm.matches(Paths.get("figure.gif")));
    }
}
