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
package tutorial.util.regex;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


/**
 * @author JiaweiMao
 * @date Jan 13, 2016 10:23:24 PM
 */
public class CharacterClass
{

    /**
     * 字符类：括在方括号中的可选字符集。
     * [0-9]表示0到9范围内所有数
     */
    @Test
    public void test1()
    {
        assertTrue(Pattern.matches("[0-9]", "1"));
    }

    /**
     * [^0-9], ^表示补集(除指定字符以外的所有字符)
     */
    @Test
    public void comple()
    {
        assertFalse(Pattern.matches("[^0-9]", "1"));
    }

    /**
     * 如果字符类中包含"-"，则必须放在开头会结尾才能匹配到'-'
     * 如果要匹配\或者是[，需要进行转义
     */
    @Test
    public void escape()
    {
        assertTrue(Pattern.matches("[-abc]", "-"));
        assertTrue(Pattern.matches("-[abc]", "-b"));
        assertTrue(Pattern.matches("[abc]-", "b-"));
        assertTrue(Pattern.matches("[\\[abc]", "["));
    }

    @Test
    public void predefined()
    {

    }
}
