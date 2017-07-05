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

package test.jdk.nio.channels;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.20, 10:10 PM
 */
public class FileChannelTest {

    /**
     * your java app lock file, then other software (e.g. notepad) can't modify and save the
     * locked file
     */
    @Test
    public void test1() {
        File f = new File("E:\\test\\afile.txt");
        RandomAccessFile raf;
        try {
            raf = new RandomAccessFile(f, "rw");
            FileChannel fc = raf.getChannel();
            FileLock lock = fc.tryLock();
            System.out.println("locked");

            if (lock.isValid()) {
                // do something here, use notepad to modify and try to save the lock file, fail!
                Thread.sleep(10000);

                lock.release();
                System.out.println("Release lock");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * when another software (e.g. Excel) lock a file, if your java app try to lock it, will throw
     * FileNotFoundException.
     */
    @Test
    public void test2() {

        // before run this class, you must use excel to open bfile.csv first, because excle lock file
        File f = new File("E:\\test\\bfile.csv");

        RandomAccessFile raf = null;

        System.out.println("Test lock method");

        try {
            raf = new RandomAccessFile(f, "rw");
            FileChannel fc = raf.getChannel();
            FileLock lock = fc.lock();

            System.out.println("locked");
            if (lock.isValid()) {
                lock.release();
                System.out.println("release lock");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        System.out.println("test trylock method");
        try {
            raf = new RandomAccessFile(f, "rw");
            FileChannel fc = raf.getChannel();
            FileLock lock = fc.tryLock();
            System.out.println("locked");
            if (lock.isValid()) {
                lock.release();
                System.out.println("release lock");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * If you try to lock file more than once in same thread or different thread, it will throw
     * OverlappingFileLockException
     */
    @Test
    public void test3SameThread() {
        System.out.println("*********************Test lock in the same thread***************");
        String filename = "E:\\test\\bfile.csv";

        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(filename, "rw");
            FileChannel fc1 = raf1.getChannel();
            raf2 = new RandomAccessFile(filename, "rw");
            FileChannel fc2 = raf2.getChannel();
            System.out.println("Grabbing first lock");
            fc1.lock();
            System.out.println("Grabbing second lock");
            fc2.tryLock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf1 != null)
                    raf1.close();
                if (raf2 != null)
                    raf2.close();
            } catch (Exception e) {
            }
        }
        System.out.println("Exiting");
    }

    @Test
    public void test3DifferentThread() throws IOException {
        String filename = "E:\\test\\bfile.csv";
        System.out.println("*********************Test lock in the different thread***************");
        RandomAccessFile raf1 = new RandomAccessFile(filename, "rw");
        FileChannel fc1 = raf1.getChannel();
        System.out.println("Grabbing first lock");
        fc1.lock();
        new Thread() {
            public void run() {
                RandomAccessFile raf2;
                try {
                    raf2 = new RandomAccessFile(filename, "rw");
                    FileChannel fc2 = raf2.getChannel();
                    System.out.println("Grabbing second lock");
                    fc2.tryLock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        System.out.println("Done");
    }

    /**
     * When one JVM is locking file, if you try to call tryLock/Lock method in another JVM, tryLock method
     * returns null immediately, lock method blocks until the previous JVM release lock.
     */
    @Test
    public void test4(){

    }

}
