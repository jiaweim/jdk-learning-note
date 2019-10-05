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

package tutorial.nio;

import org.testng.annotations.Test;

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
public class ScatteringByteChannelTest {

    @Test
    public void test() throws IOException {

        ScatteringByteChannel src = (ScatteringByteChannel) Channels.newChannel(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("sample.txt")));
        ByteBuffer b1 = ByteBuffer.allocateDirect(5);
        ByteBuffer b2 = ByteBuffer.allocateDirect(3);

        ByteBuffer[] bs = {b1, b2};
        src.read(bs);
        b1.flip();
        while (b1.hasRemaining()){
            System.out.println(b1.get());
        }

        b2.flip();
        while (b2.hasRemaining()){
            System.out.println(b2.get());
        }

        b1.rewind();
        b2.rewind();
    }

}
