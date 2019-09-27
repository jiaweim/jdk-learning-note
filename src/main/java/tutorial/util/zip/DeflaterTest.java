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
package tutorial.util.zip;


import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;


/**
 * ZLIB库 Deflater 用于压缩数据
 *
 * @author JiaweiMao
 * @date Mar 12, 2016 4:37:09 PM
 */
public class DeflaterTest
{

    @Test
    public final void testBytes()
    {
        String inputStr = "snowolf@zlex.org;dongliang@zlex.org;zlex.dongliang@zlex.org";
        assertEquals(59, inputStr.length());
        byte[] input = inputStr.getBytes();
        assertEquals(59, input.length);

        byte[] data = ZLibUtils.compress(input);
        System.err.println("压缩后字节长度:\t" + data.length);

        byte[] output = ZLibUtils.decompress(data);
        System.err.println("解压缩后字节长度:\t" + output.length);
        String outputStr = new String(output);
        System.err.println("输出字符串:\t" + outputStr);

        assertEquals(inputStr, outputStr);
    }

    @Test
    public final void testFile()
    {
        String filename = "zlib";
        File file = new File(filename);
        System.err.println("文件压缩／解压缩测试");
        String inputStr = "snowolf@zlex.org;dongliang@zlex.org;zlex.dongliang@zlex.org";
        System.err.println("输入字符串:\t" + inputStr);
        byte[] input = inputStr.getBytes();
        System.err.println("输入字节长度:\t" + input.length);

        try {

            FileOutputStream fos = new FileOutputStream(file);
            ZLibUtils.compress(input, fos);
            fos.close();
            System.err.println("压缩后字节长度:\t" + file.length());
        } catch (Exception e) {
            fail(e.getMessage());
        }

        byte[] output = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            output = ZLibUtils.decompress(fis);
            fis.close();

        } catch (Exception e) {
            fail(e.getMessage());
        }
        System.err.println("解压缩后字节长度:\t" + output.length);
        String outputStr = new String(output);
        System.err.println("输出字符串:\t" + outputStr);

        assertEquals(inputStr, outputStr);
    }

    @Test
    public void test1()
    {
        try {
            String inpu = "blahblahblah??";
            assertEquals(14, inpu.length());
            byte[] input = inpu.getBytes("UTF-8");
            assertEquals(14, input.length);

            // 执行压缩
            byte[] out = new byte[100];
            Deflater compresser = new Deflater();
            compresser.setInput(input);
            compresser.finish();
            int compressedDataLength = compresser.deflate(out);
            System.out.println(out.length);
            System.out.println(compressedDataLength);

            // Decompress the bytes
            Inflater decompresser = new Inflater();
            decompresser.setInput(out, 0, compressedDataLength);
            byte[] result = new byte[100];
            int resultLength = decompresser.inflate(result);
            decompresser.end();

            // Decode the bytes into a string
            String outputString = new String(result, 0, resultLength, "UTF-8");
            System.out.println(resultLength);
            System.out.println(outputString);

        } catch (UnsupportedEncodingException | DataFormatException e) {
            e.printStackTrace();
        }
    }
}
