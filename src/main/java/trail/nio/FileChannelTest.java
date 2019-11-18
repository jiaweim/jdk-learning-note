package trail.nio;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.20, 10:10 PM
 */
class FileChannelTest
{
    @Test
    void testWrite() throws IOException, URISyntaxException
    {
        Path tempFile = Files.createTempFile(null, "");

        FileChannel fc = new FileOutputStream(tempFile.toFile()).getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(12);
        buffer.putInt(1);
        buffer.putInt(2);
        buffer.putInt(3);
        buffer.flip();
        fc.write(buffer);
        fc.close();

        fc = new RandomAccessFile(tempFile.toFile(), "rw").getChannel();
        fc.position(Integer.BYTES);

        buffer = ByteBuffer.allocate(100);
        buffer.putInt(6);
        buffer.flip();
        fc.write(buffer);
        fc.close();


        fc = new FileInputStream(tempFile.toFile()).getChannel();
        buffer = ByteBuffer.allocate(100);
        fc.read(buffer);
        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.println(buffer.getInt());
        }

    }

    @Test
    public void testCopy() throws URISyntaxException, IOException
    {
        MappedByteBuffer out = new RandomAccessFile(getClass().getResource("text.txt").toURI().getPath(), "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 1, 1);
        out.putChar('E');
    }

    @Test
    public void testRead() throws IOException
    {

        String file = "data.txt";
        String txt = "Hello World";
        String txt2 = " Dream";

        FileChannel fc = new FileOutputStream(file).getChannel();
        fc.write(ByteBuffer.wrap(txt.getBytes()));
        fc.close();

        // add content to end of file
        fc = new RandomAccessFile(file, "rw").getChannel();
        fc.position(fc.size()); // move to the end
        fc.write(ByteBuffer.wrap(txt2.getBytes()));
        fc.close();

        // read the file
        fc = new FileInputStream(file).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fc.read(buffer);
        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }
        fc.close();


//        buffer.clear();
//        buffer.putInt(1);
//        buffer.putInt(2);
//        buffer.putInt(3);
//
//        buffer.flip();
    }


    /**
     * your java app lock file, then other software (e.g. notepad) can't modify and save the
     * locked file
     */
    @Test
    public void test1()
    {
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
    public void test2()
    {

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
    public void test3SameThread()
    {
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
    public void test3DifferentThread() throws IOException
    {
        String filename = "E:\\test\\bfile.csv";
        System.out.println("*********************Test lock in the different thread***************");
        RandomAccessFile raf1 = new RandomAccessFile(filename, "rw");
        FileChannel fc1 = raf1.getChannel();
        System.out.println("Grabbing first lock");
        fc1.lock();
        new Thread()
        {
            public void run()
            {
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
    public void test4()
    {

    }

}
