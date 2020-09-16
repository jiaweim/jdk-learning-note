package cn.mjw.hello.nio;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 27 Jan 2019, 2:51 PM
 */
class ByteBufferTest
{
    @Test
    void testConvert() throws IOException
    {
        FileChannel fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();

        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(1024);
        fc.read(buff);
        buff.flip();
        buff.rewind();
    }

    @Test
    void testAllocate()
    {
        Buffer buffer = ByteBuffer.allocate(7);
        assertEquals(buffer.capacity(), 7);
        assertEquals(buffer.limit(), 7);
        assertEquals(buffer.position(), 0);
        assertEquals(buffer.remaining(), 7); // the number of elements between the current position and the limit

        buffer.limit(5); // set this buffer's limit to newLimit. When the position is larger than newLimit,
        // the position is set to newLimit. When the mark is defined and is larger than newLimit, the mark is discarded.
        // This method throws IllegalArgumentException when newLimit is negative or larger than this buffer's capacity; otherwise
        // it returns this buffer
        assertEquals(buffer.limit(), 5);
        assertEquals(buffer.position(), 0);
        assertEquals(buffer.remaining(), 5);

        buffer.position(3);
        assertEquals(buffer.position(), 3);
        assertEquals(buffer.remaining(), 2);
        assertEquals(buffer.capacity(), 7);

        buffer = ByteBuffer.allocate(10);
        assertTrue(buffer.hasArray());
        assertEquals(buffer.arrayOffset(), 0);
        assertEquals(buffer.capacity(), 10);
        assertEquals(buffer.limit(), 10);
        assertEquals(buffer.position(), 0);
        assertEquals(buffer.remaining(), 10);
    }

    @Test
    void testWrap()
    {
        byte[] bytes = new byte[200];
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        buffer.put((byte) 1);
        assertEquals(bytes[0], 1);

        ByteBuffer b2 = ByteBuffer.wrap(bytes, 10, 50);
        assertTrue(b2.hasArray());
        assertEquals(b2.arrayOffset(), 0);
        assertEquals(b2.capacity(), 200);
        assertEquals(b2.position(), 10);
        assertEquals(b2.limit(), 60);
        b2.duplicate();
    }

    @Test
    void testPut()
    {
        ByteBuffer buffer = ByteBuffer.allocate(6);
        assertEquals(buffer.capacity(), 6);
        assertEquals(buffer.limit(), 6);
        assertEquals(buffer.position(), 0);
        assertEquals(buffer.remaining(), 6);

        buffer.put((byte) 15).put((byte) 13).put((byte) 21);
        assertEquals(buffer.capacity(), 6);
        assertEquals(buffer.limit(), 6);
        assertEquals(buffer.position(), 3);
        assertEquals(buffer.remaining(), 3);

        assertEquals(buffer.get(0), 15);
        assertEquals(buffer.get(3), 0);
    }

    @Test
    void testFlip()
    {
        ByteBuffer buffer = ByteBuffer.allocate(6);
        buffer.put((byte) 10).put((byte) 20).put((byte) 30);
        assertEquals(buffer.capacity(), 6);
        assertEquals(buffer.position(), 3);
        assertEquals(buffer.limit(), 6);
        assertEquals(buffer.remaining(), 3);

        buffer.flip();
        assertEquals(buffer.capacity(), 6);
        assertEquals(buffer.position(), 0);
        assertEquals(buffer.limit(), 3);
        assertEquals(buffer.remaining(), 3);
    }

    @Test
    void testMark()
    {
        ByteBuffer buffer = ByteBuffer.allocate(7);
        buffer.put((byte) 10).put((byte) 20).put((byte) 30).put((byte) 40);
        buffer.limit(4);
        assertEquals(buffer.position(), 4);
        assertEquals(buffer.limit(), 4);
        assertEquals(buffer.capacity(), 7);

        buffer.position(1);
        assertEquals(buffer.position(), 1);
        buffer.mark();

        buffer.position(3);
        assertEquals(buffer.position(), 3);
        assertEquals(buffer.get(), 40);
        assertEquals(buffer.position(), 4);

        buffer.reset();
        assertEquals(buffer.position(), 1);
    }

    @Test
    void testCompact()
    {
        ByteBuffer buffer = ByteBuffer.allocate(7);
        buffer.put((byte) 20).put((byte) 30).put((byte) 40);
        buffer.compact();
    }

}
