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
package trail.util.zip;

import java.io.ByteArrayOutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * @author JiaweiMao
 * @date Mar 12, 2016 4:37:46 PM
 */
public class CompressionTools {

	// Export only static methods
	private CompressionTools() {}

	public static byte[] compress(byte[] value, int offset, int length, int compressionLevel) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream(length);

		Deflater compressor = new Deflater();

		try {
			compressor.setLevel(compressionLevel); // 将当前压缩级别设置为指定值。
			compressor.setInput(value, offset, length);
			compressor.finish(); // 调用时，指示压缩应当以输入缓冲区的当前内容结尾。

			// Compress the data
			final byte[] buf = new byte[1024];
			while (!compressor.finished()) {
				// 如果已到达压缩数据输出流的结尾，则返回 true。
				int count = compressor.deflate(buf);
				// 使用压缩数据填充指定缓冲区。
				bos.write(buf, 0, count);
			}
		} finally {
			compressor.end(); // 关闭解压缩器并放弃所有未处理的输入。
		}

		return bos.toByteArray();
	}

	public static byte[] compress(byte[] value, int offset, int length) {
		return compress(value, offset, length, Deflater.BEST_COMPRESSION);
		// 最佳压缩的压缩级别
	}

	public static byte[] compress(byte[] value) {
		return compress(value, 0, value.length, Deflater.BEST_COMPRESSION);
	}

	public static byte[] decompress(byte[] value) throws DataFormatException {

		ByteArrayOutputStream bos = new ByteArrayOutputStream(value.length);

		Inflater decompressor = new Inflater();

		try {
			decompressor.setInput(value);

			final byte[] buf = new byte[1024];
			while (!decompressor.finished()) {
				int count = decompressor.inflate(buf);
				bos.write(buf, 0, count);
			}
		} finally {
			decompressor.end();
		}

		return bos.toByteArray();
	}

}
