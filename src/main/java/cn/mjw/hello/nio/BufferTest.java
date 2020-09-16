package cn.mjw.hello.nio;

import org.junit.jupiter.api.Test;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 27 Jan 2019, 4:31 PM
 */
public class BufferTest
{
    @Test
    public void testCreate1()
    {
        ByteBuffer buffer = ByteBuffer.allocate(6);
        assertEquals(buffer.position(), 0);
        assertEquals(buffer.capacity(), 6);
        assertEquals(buffer.limit(), 6);
        assertEquals(buffer.arrayOffset(), 0);
        assertEquals(buffer.get(0), 0);

        buffer = ByteBuffer.allocate(10);
        assertTrue(buffer.hasArray());
        assertEquals(buffer.array(), new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertEquals(buffer.capacity(), 10);
        assertEquals(buffer.limit(), 10);
        assertEquals(buffer.position(), 0);
        assertEquals(buffer.remaining(), 10);

        byte[] bytes = new byte[200];
        ByteBuffer buffer2 = ByteBuffer.wrap(bytes);
        assertTrue(buffer2.hasArray());

        buffer2 = ByteBuffer.wrap(bytes, 10, 50);
        assertTrue(buffer2.hasArray());
        assertEquals(buffer2.capacity(), bytes.length);
        assertEquals(buffer2.position(), 10);
        assertEquals(buffer2.limit(), 10 + 50);
        assertEquals(buffer2.remaining(), 50);
    }

    @Test
    public void testWrap()
    {
        byte[] array = new byte[]{1, 2, 3, 4};
        ByteBuffer buffer = ByteBuffer.wrap(array); // modifications to the buffer will cause the array to be modified and vice versa.
        assertEquals(buffer.get(1), 2);
        array[1] = 6;
        assertEquals(buffer.get(1), 6);

        buffer.put(0, (byte) 0);
        assertEquals(array[0], 0);
    }

    @Test
    public void testWrap2()
    {
        byte[] array = new byte[]{1, 2, 3, 4};
        ByteBuffer buffer = ByteBuffer.wrap(array, 1, 2);
        assertEquals(buffer.capacity(), array.length); // the buffer's capacity is set to the array.length
        assertEquals(buffer.position(), 1); // the position is set to offset
        assertEquals(buffer.limit(), 3); // the limit is set to offset+length
        assertEquals(buffer.arrayOffset(), 0);
    }

    @Test
    public void testDuplicate()
    {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        ByteBuffer bufferView = buffer.duplicate();
    }

    @Test
    public void testRead()
    {
        ByteBuffer buffer = ByteBuffer.allocate(7);
        assertEquals(buffer.capacity(), 7);
        assertEquals(buffer.limit(), 7);
        assertEquals(buffer.position(), 0);
        assertEquals(buffer.remaining(), 7);

        buffer.put((byte) 10).put((byte) 20).put((byte) 30);
        assertEquals(buffer.capacity(), 7);
        assertEquals(buffer.limit(), 7);
        assertEquals(buffer.position(), 3);
        assertEquals(buffer.remaining(), 4);
        assertEquals(buffer.get(0), 10);
        assertEquals(buffer.get(1), 20);
        assertEquals(buffer.get(2), 30);
    }

    @Test
    public void testFlip()
    {
        String[] poem = {
                "Roses are red",
                "Violets are blue",
                "Sugar is sweet",
                "And so are you."};
        CharBuffer buffer = CharBuffer.allocate(50);
        for (int i = 0; i < poem.length; i++) {
            // Fill the buffer.
            for (int j = 0; j < poem[i].length(); j++)
                buffer.put(poem[i].charAt(j));
            // Flip the buffer so that its contents can be read.
            buffer.flip();
            // Drain the buffer.
            while (buffer.hasRemaining())
                System.out.print(buffer.get());
            // Empty the buffer to prevent BufferOverflowException.
            buffer.clear();
            System.out.println();
        }

    }

    @Test
    public void testMark()
    {
        ByteBuffer buffer = ByteBuffer.allocate(7);
        buffer.put((byte) 10).put((byte) 20).put((byte) 30).put((byte) 40);
        buffer.limit(4);
        buffer.position(1).mark().position(3);
        assertEquals(buffer.get(), 40);
        buffer.reset();
        assertEquals(buffer.get(), 20);
        assertEquals(buffer.get(), 30);
        assertEquals(buffer.get(), 40);
        assertThrows(BufferUnderflowException.class, buffer::get);
    }
}
