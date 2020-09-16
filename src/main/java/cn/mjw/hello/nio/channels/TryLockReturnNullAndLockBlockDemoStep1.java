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

package cn.mjw.hello.nio.channels;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class TryLockReturnNullAndLockBlockDemoStep1 {
    public static void main(String args[]) {
        String fileName = "E:\\test\\bfile.csv";
        try {
            RandomAccessFile r = new RandomAccessFile(fileName, "rw");
            FileChannel channel = r.getChannel();
            FileLock fl = channel.tryLock();
            System.out.println("FileLock obj is valid? " + fl.isValid());
            Thread.sleep(10000);
            System.out.println("release lock");
            channel.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}