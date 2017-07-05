/*
 * Copyright 2017 Jiawei Mao
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
package test.jdk.lang;


import org.junit.jupiter.api.Test;

/**
 * Package 对象包含有关Java包的实现和规范的版本信息。
 *
 * @version 1.00
 * @author JiaweiMao
 * @date Jun 14 2016, 20:54
 */
public class PackageTest {

    /**
     * 当前类加载器所有的类.
     */
    @Test
    public void testGetPackages(){

        Package[] packages = Package.getPackages();
        for(Package p : packages){
            System.out.println(p.getName());
        }
    }

    @Test
    public void testGetImplementationVersion(){
        Package aPackage = Package.getPackage("cn.ac.dicp.jdk");
        System.out.println(aPackage.getName());
        System.out.println(aPackage.getImplementationTitle());
        System.out.println(aPackage.getImplementationVendor());
//        System.out.println(aPackage.getImplementationVersion());
    }

}
