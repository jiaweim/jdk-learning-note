package test.jdk.nio.channels;

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