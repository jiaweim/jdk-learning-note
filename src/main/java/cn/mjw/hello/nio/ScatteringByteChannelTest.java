package cn.mjw.hello.nio;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ScatteringByteChannel;
import java.util.Objects;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 03 Oct 2019, 9:25 PM
 */
class ScatteringByteChannelTest
{
    @Test
    void test() throws IOException
    {
        ScatteringByteChannel src = (ScatteringByteChannel) Channels.newChannel(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("sample.txt")));
        ByteBuffer b1 = ByteBuffer.allocateDirect(5);
        ByteBuffer b2 = ByteBuffer.allocateDirect(3);

        ByteBuffer[] bs = {b1, b2};
        src.read(bs);
        b1.flip();
        while (b1.hasRemaining()) {
            System.out.println(b1.get());
        }

        b2.flip();
        while (b2.hasRemaining()) {
            System.out.println(b2.get());
        }

        b1.rewind();
        b2.rewind();
    }

}
