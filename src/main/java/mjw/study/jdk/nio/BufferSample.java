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

package mjw.study.jdk.nio;

import java.nio.ByteBuffer;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 01 May 2019, 4:28 PM
 */
public class BufferSample
{
    public static void main(String[] args)
    {
        // Allocating a Buffer
        ByteBuffer buffer = ByteBuffer.allocate(33);
        System.out.println("-------------Test reset-------------");

        // clear(), position=0, limit=capacity
        buffer.clear();
        // set position
        buffer.position(5);
        buffer.mark();

        buffer.position(10);
        System.out.println("before reset:      " + buffer);
        buffer.reset();
        System.out.println("after reset:       " + buffer);
        System.out.println("-------------Test rewind-------------");
        buffer.clear();
        buffer.position(10);
        buffer.limit(15);

        System.out.println("before rewind:       " + buffer);
        // positon=0, mark=-1
        buffer.rewind();


//把position设为0，mark设为-1，不改变limit的值

        buffer
                .
                        rewind
                                ();


        System
                .
                        out
                .
                        println
                                (
                                        "before rewind:       "

                                                +
                                                buffer
                                );


        System
                .
                        out
                .
                        println
                                (
                                        "-------------Test compact-------------"
                                );

        buffer
                .
                        clear
                                ();

        buffer
                .
                        put
                                (
                                        "abcd"
                                                .
                                                        getBytes
                                                                ());


        System
                .
                        out
                .
                        println
                                (
                                        "before compact:       "

                                                +
                                                buffer
                                );


        System
                .
                        out
                .
                        println
                                (
                                        new

                                                String
                                                (
                                                        buffer
                                                                .
                                                                        array
                                                                                ()));


//limit = position;position = 0;mark = -1; 翻转，也就是让flip之后的position到limit这块区域变成之前的0到position这块，


//翻转就是将一个处于存数据状态的缓冲区变为一个处于准备取数据的状态

        buffer
                .
                        flip
                                ();


        System
                .
                        out
                .
                        println
                                (
                                        "after flip:       "

                                                +
                                                buffer
                                );


//get()方法：相对读，从position位置读取一个byte，并将position+1，为下次读写作准备


        System
                .
                        out
                .
                        println
                                ((
                                        char
                                        )
                                        buffer
                                                .
                                                        get
                                                                ());


        System
                .
                        out
                .
                        println
                                ((
                                        char
                                        )
                                        buffer
                                                .
                                                        get
                                                                ());


        System
                .
                        out
                .
                        println
                                ((
                                        char
                                        )
                                        buffer
                                                .
                                                        get
                                                                ());


        System
                .
                        out
                .
                        println
                                (
                                        "after three gets:       "

                                                +
                                                buffer
                                );


        System
                .
                        out
                .
                        println
                                (
                                        "\t"

                                                +

                                                new

                                                        String
                                                        (
                                                                buffer
                                                                        .
                                                                                array
                                                                                        ()));


//把从position到limit中的内容移到0到limit-position的区域内，position和limit的取值也分别变成limit-position、capacity。


// 如果先将positon设置到limit，再compact，那么相当于clear()

        buffer
                .
                        compact
                                ();


        System
                .
                        out
                .
                        println
                                (
                                        "after compact:       "

                                                +
                                                buffer
                                );


        System
                .
                        out
                .
                        println
                                (
                                        "\t"

                                                +

                                                new

                                                        String
                                                        (
                                                                buffer
                                                                        .
                                                                                array
                                                                                        ()));


        System
                .
                        out
                .
                        println
                                (
                                        "-------------Test get-------------"
                                );

        buffer
                =

                ByteBuffer
                        .
                                allocate
                                        (
                                                32
                                        );

        buffer
                .
                        put
                                ((
                                        byte
                                        )

                                        'a'
                                ).
                put
                        ((
                                byte
                                )

                                'b'
                        ).
                put
                        ((
                                byte
                                )

                                'c'
                        ).
                put
                        ((
                                byte
                                )

                                'd'
                        )


                .
                        put
                                ((
                                        byte
                                        )

                                        'e'
                                ).
                put
                        ((
                                byte
                                )

                                'f'
                        );


        System
                .
                        out
                .
                        println
                                (
                                        "before flip():       "

                                                +
                                                buffer
                                );


// 转换为读取模式

        buffer
                .
                        flip
                                ();


        System
                .
                        out
                .
                        println
                                (
                                        "before get():       "

                                                +
                                                buffer
                                );


        System
                .
                        out
                .
                        println
                                ((
                                        char
                                        )
                                        buffer
                                                .
                                                        get
                                                                ());


        System
                .
                        out
                .
                        println
                                (
                                        "after get():       "

                                                +
                                                buffer
                                );


// get(index)不影响position的值


        System
                .
                        out
                .
                        println
                                ((
                                        char
                                        )
                                        buffer
                                                .
                                                        get
                                                                (
                                                                        2
                                                                ));


        System
                .
                        out
                .
                        println
                                (
                                        "after get(index):       "

                                                +
                                                buffer
                                );


        byte
                []
                dst
                =

                new

                        byte
                        [
                        10
                        ];

        buffer
                .
                        get
                                (
                                        dst
                                        ,

                                        0
                                        ,

                                        2
                                );


        System
                .
                        out
                .
                        println
                                (
                                        "after get(dst, 0, 2):       "

                                                +
                                                buffer
                                );


        System
                .
                        out
                .
                        println
                                (
                                        "\t dst:"

                                                +

                                                new

                                                        String
                                                        (
                                                                dst
                                                        ));


        System
                .
                        out
                .
                        println
                                (
                                        "buffer now is:       "

                                                +
                                                buffer
                                );


        System
                .
                        out
                .
                        println
                                (
                                        "\t"

                                                +

                                                new

                                                        String
                                                        (
                                                                buffer
                                                                        .
                                                                                array
                                                                                        ()));


        System
                .
                        out
                .
                        println
                                (
                                        "-------------Test put-------------"
                                );


        ByteBuffer
                bb
                =

                ByteBuffer
                        .
                                allocate
                                        (
                                                32
                                        );


        System
                .
                        out
                .
                        println
                                (
                                        "before put(byte):       "

                                                +
                                                bb
                                );


        System
                .
                        out
                .
                        println
                                (
                                        "after put(byte):       "

                                                +
                                                bb
                                                        .
                                                                put
                                                                        ((
                                                                                byte
                                                                                )

                                                                                'z'
                                                                        ));


        System
                .
                        out
                .
                        println
                                (
                                        "\t"

                                                +
                                                bb
                                                        .
                                                                put
                                                                        (
                                                                                2
                                                                                ,

                                                                                (
                                                                                        byte
                                                                                        )

                                                                                        'c'
                                                                        ));


// put(2,(byte) 'c')不改变position的位置


        System
                .
                        out
                .
                        println
                                (
                                        "after put(2,(byte) 'c'):       "

                                                +
                                                bb
                                );


        System
                .
                        out
                .
                        println
                                (
                                        "\t"

                                                +

                                                new

                                                        String
                                                        (
                                                                bb
                                                                        .
                                                                                array
                                                                                        ()));


// 这里的buffer是 abcdef[pos=3 lim=6 cap=32]

        bb
                .
                        put
                                (
                                        buffer
                                );


        System
                .
                        out
                .
                        println
                                (
                                        "after put(buffer):       "

                                                +
                                                bb
                                );


        System
                .
                        out
                .
                        println
                                (
                                        "\t"

                                                +

                                                new

                                                        String
                                                        (
                                                                bb
                                                                        .
                                                                                array
                                                                                        ()));
    }
}
