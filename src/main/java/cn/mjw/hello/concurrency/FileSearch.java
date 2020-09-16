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

package cn.mjw.hello.concurrency;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * 利用 {@link InterruptedException} 实现中断控制
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 17 Jan 2019, 8:43 PM
 */
public class FileSearch implements Runnable
{
    private String initPath;
    private String fileName;

    public FileSearch(String initPath, String fileName)
    {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    public static void main(String[] args)
    {
        FileSearch search = new FileSearch("C:\\", "unimod.xml");
        Thread thread = new Thread(search);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    @Override
    public void run()
    {
        File file = new File(initPath);
        if (file.isDirectory()) {
            try {
                directoryProcess(file);
            } catch (InterruptedException e) {
                System.out.printf("%s: The search has been interrupted", Thread.currentThread().getName());
            }
        }
    }

    private void directoryProcess(File file) throws InterruptedException
    {
        File[] files = file.listFiles();
        if (files != null) {
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    directoryProcess(file1);
                } else {
                    fileProcess(file1);
                }
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    /**
     * 比较当前文件的文件名和要查找的文件名，如果匹配，将信息打印出来。
     * 做完比较厚，检查线程是否被中断了，如果是，抛出异常。
     */
    private void fileProcess(File file) throws InterruptedException
    {
        if (file.getName().equals(fileName)) {
            System.out.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }
}
