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

package trail.nio;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 03 Oct 2019, 10:46 PM
 */
public class MappedIO {

    private static int numOfInts = 4000000;
    private static int numOfBuffInts = 200000;

    private abstract static class Tester {
        private String name;

        public Tester(String name) {
            this.name = name;
        }

        public void runTest() {
            System.out.print(name + ": ");
            try {
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.printf("%.2f\n", duration / 1.e9);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public abstract void test() throws IOException;
    }

    private static Tester[] test = {
            new Tester("Stream Write") {
                @Override
                public void test() throws IOException {
                    DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("temp.tmp"))));
                    for (int i = 0; i < numOfInts; i++)
                        dos.writeInt(i);
                    dos.close();
                }
            },
            new Tester("Mapped Write") {
                @Override
                public void test() throws IOException {
                    FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
                    IntBuffer intBuffer = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                    for (int i = 0; i < numOfInts; i++)
                        intBuffer.put(i);
                    fc.close();
                }
            },
            new Tester("Stream Read") {
                @Override
                public void test() throws IOException {
                    DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("temp.tmp")));
                    for (int i = 0; i < numOfInts; i++)
                        dis.readInt();
                    dis.close();
                }
            },
            new Tester("Mapped Read") {
                @Override
                public void test() throws IOException {
                    FileChannel fc = new FileInputStream(new File("temp.tmp")).getChannel();
                    IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
                    while (ib.hasRemaining()) {
                        ib.get();
                    }
                    fc.close();
                }
            },
            new Tester("Stream Read/Write") {
                @Override
                public void test() throws IOException {
                    RandomAccessFile raf = new RandomAccessFile(new File("temp.tmp"), "rw");
                    raf.writeInt(1);
                    for (int i = 0; i < numOfBuffInts; i++) {
                        raf.seek(raf.length() - 4);
                        raf.writeInt(raf.readInt());
                    }
                    raf.close();
                }
            },
            new Tester("Mapped Read/Write") {
                @Override
                public void test() throws IOException {
                    FileChannel fc = new RandomAccessFile(new File("temp.tmp"), "rw").getChannel();
                    IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                    ib.put(0);
                    for (int i = 1; i < numOfBuffInts; i++) {
                        ib.put(ib.get(i - 1));
                    }
                    fc.close();
                }
            }
    };

    public static void main(String[] args) {
        for (Tester tester : test) {
            tester.runTest();
        }
    }
}
