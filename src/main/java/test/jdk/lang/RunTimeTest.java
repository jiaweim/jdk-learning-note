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

package test.jdk.lang;


import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author JiaweiM
 * @date Jul 9, 2015 3:56:25 PM
 */
class RunTimeTest {

    @Test
    void availableProcess() {

        Runtime runtime = Runtime.getRuntime();
        int processorCount = runtime.availableProcessors();
        assertTrue(processorCount > 0);

    }

    /**
     * 返回java虚拟机能够从操作系统获得的最大内存，以字节为单位；
     * 运行Java程序时如果没有添加-Xmx，那么就是64M，即maxMemory()返回
     * 的大约是64*1024*1024字节，这是java虚拟机默认情况下能从操作系统那里
     * 挖到的最大内存。如果添加了-Xmx参数，将以这个参数后面的值为准，例如java -cp classpath -Xmx512m youclass，
     * 那么最大内存就是512*1024*1024字节。
     */
    @Test
    public void testMaxmemory() {
        Runtime r = Runtime.getRuntime();
        assertEquals(1, r.maxMemory() / (1024 * 1024 * 1024));
    }

    /**
     * totalMemory 返回Java虚拟机现在已经从操作系统获得的内存，如果在运行java的时候没有添加
     * -xms参数，那么java程序运行时，内存总是慢慢从操作系统那里挖，用多少挖多少，直到maxMemory为止，所以totalMemory
     * 是慢慢增大的。如果用了-Xms参数，程序在启动时去条件从操作系统挖-Xms后面的内存，然后在这些内存用的差不多的
     * 时候再去挖。
     */
    @Test
    public void testTotalMemory() {
        Runtime r = Runtime.getRuntime();
        // 内存不足maxmemory，比值值小于1，所以为0
        assertEquals(0, r.totalMemory() / (1024 * 1024 * 1024));
        // 将值转换为double
        assertTrue(r.totalMemory() / (1024 * 1024 * 1024.0) < 1);
        assertTrue(r.totalMemory() / (1024 * 1024 * 1024.0) > 0);
        assertTrue(r.totalMemory() / (1024 * 1024) < 256);
    }

    /**
     * 如果在运行java的时候没有添加-Xms参数，那么在Java运行过程中，内存总是慢慢的从操作系统挖过来，基本
     * 是用多少挖多少，但是Java虚拟机总会稍微多挖一点，这些挖过来又还没用的内存，就是freeMemory()，所以freeMemory()
     * 一般都很小，如果你在运行Java程序的时候使用了-Xms，这个时候因为程序在启动时会无条件从操作系统中挖-Xms后面定义的内存，
     * 这个时候挖过来的内存大部分没用上，所以这个时候freeMemory可能会有些大。
     */
    @Test
    public void testFreeMemory() {
        Runtime r = Runtime.getRuntime();
        assertTrue(r.freeMemory() / (1024 * 1024) < 256);
    }

    /**
     * 通过totalMemory()和freeMemory()可以查看堆内存。
     * Java会周期性的回收垃圾，但是如果想先于收集器收集垃圾，可以通过gc()。可以先调用gc()，然后调用
     * freeMemory()方法查看基本的内存使用情况。
     */
    @Test
    @Ignore
    public void testMemoryManagement() {
        Runtime r = Runtime.getRuntime();
        long mem1, mem2;
        Integer someints[] = new Integer[1000];
        System.out.println("Total memory is ：" + r.totalMemory());
        mem1 = r.freeMemory();
        System.out.println("Initial free is : " + mem1);
        r.gc();
        mem1 = r.freeMemory();
        System.out.println("Free memory after garbage collection : " + mem1);
        // allocate integers
        for (int i = 0; i < 1000; i++)
            someints[i] = i;
        mem2 = r.freeMemory();
        System.out.println("Free memory after allocation : " + mem2);
        System.out.println("Memory used by allocation : " + (mem1 - mem2));
        // discard Intergers
        for (int i = 0; i < 1000; i++)
            someints[i] = null;
        r.gc(); // request garbage collection
        mem2 = r.freeMemory();
        System.out.println("Free memory after collecting " + "discarded integers : " + mem2);
    }

    /**
     * 使用Runtime.getRuntime().exec()可以执行Java外部程序。
     * 打开一个不可执行的文件：
     * 打开一个不可执行的文件，但该文件有关联的应用程序，则可以有两种打开方式。以打开一个word文档为例
     *
     * @throws IOException
     */
    @Test
    @Ignore
    public void testExec() throws IOException {
        Runtime.getRuntime().exec("start E:\\downloads\\国际音标讲义.doc");
    }

    /**
     * 在安全的环境中，可以在多任务操作系统中使用Java去执行其他特别大的进程。exec()方法有几种形式。exec()返回一个Process对象，
     * 可以使用 这个对象控制Java程序与新运行的程序进行交互，exec()本质依赖于环境。
     * 下例使用exec()启动windows记事本notepad，这个例子依赖于WIndows操作系统。
     */
    @Test
    @Ignore
    public void execApp() {
        Runtime r = Runtime.getRuntime();
        Process process = null;
        try {
            process = r.exec("notepad");
        } catch (Exception e) {
            System.out.println("Error executing notepad");
        }
    }

    /**
     * exec()还有其他几种形式，上例是最常见的一种。exec()返回Process对象后，在新程序开始运行后可就可以使用Process的方法了。
     * 可以用destory()方法杀死子进程，也可以使用waitFor()方法等待程序知道子程序结束，exitValue()方法返回子进程
     * 结束时返回的值，如果正确，返回0.
     */
    @Test
    public void execApp2() {
        Runtime r = Runtime.getRuntime();
        Process p = null;
        try {
            p = r.exec("notepad");
            p.waitFor();
        } catch (Exception e) {
            System.out.println("Error executing notepad.");
        }
        System.out.println("Notepad returned " + p.exitValue());
    }


    @Test
    @Ignore
    public void testMemoryInfo() {
        // maxMemory is the upper limit the jvm can use
        double max = Runtime.getRuntime().maxMemory() / 1024;
        // totalMemory the size of the current allocation pool
        double allocated = Runtime.getRuntime().totalMemory() / 1024;
        // non allocated memory till jvm limit
        double nonAllocated = max - allocated;
        // freeMemory, the unused memory int the allocation pool
        double cached = Runtime.getRuntime().freeMemory() / 1024;

        double used = allocated - cached; // really used memory
        double useable = max - used; // allocated, but non-used and non-allocated memory

        System.out.println("jvm upper limit: maxMemory = " + max);
        System.out.println("allocation pool: totalMemory = " + allocated);
        System.out.println("nonAllocated: maxMemory - totalMemory = " + nonAllocated);
        System.out.println("freeMemory in pool: freeMemory = " + cached);
        System.out.println("really used memory = totalMemory - freeMemory" + used);
        System.out.println("available memory: maxMemory - totalMemory + freeMemory = " + useable);
    }
}
