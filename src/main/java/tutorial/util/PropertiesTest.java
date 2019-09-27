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

package tutorial.util;

import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;

/**
 *
 * @Class PropertiesTest
 * @author JiaweiM
 * @date Jul 9, 2015 5:00:55 PM
 */
public class PropertiesTest
{

    @Test
    public void test() throws IOException
    {

        System.out.println("------------testProperties-------------");
        // 将properties文件加载到输入字节流中
        InputStream is = new FileInputStream("E:\\FileFormat\\test.properties");
        // 创建一个Properties容器
        Properties prop = new Properties();
        // 从流中加载properties文件信息
        prop.load(is);
        // 循环输出配置信息
        for (Object key : prop.keySet()) {
            System.out.println(key + "=" + prop.get(key));
        }

        // 定义一个输出流
        OutputStream os1 = new FileOutputStream("E:\\FileFormat\\ttt.xml");
        OutputStream os2 = new FileOutputStream("E:\\FileFormat\\ttt.properties");

        // 从Properties对象导出导出到xml
        prop.storeToXML(os1, "我从properties导出的XML配置文件");
        // 从Properties对象导出properties文件
        prop.store(os2, "我从properties导出的XML配置文件");

        is.close();
        os1.close();
        os2.close();

        // 从xml加载配置信息，填充Properties容器
        prop.loadFromXML(new FileInputStream("E:\\FileFormat\\ttt.xml"));
        // 循环输出配置信息
        System.out.println("我从导出的xml加载配置文件信息！");
        for (Object key : prop.keySet()) {
            System.out.println(key + "=" + prop.get(key));
        }

        // 修改Properties对象，并持久化到一个文件
        prop.put("呵呵呵", "嘎嘎嘎");
        OutputStream os3 = new FileOutputStream("E:\\FileFormat\\ttt1.xml");
        prop.storeToXML(os3, "我从properties导出的XML配置文件");
        os3.close();
    }

}
