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
package cn.mjw.hello.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 * @author JiaweiMao
 * @date Mar 12, 2016 4:29:59 PM
 */
public class ObjectStreams {
	static final String dataFile = "invoicedata";

	static final BigDecimal[] prices = { new BigDecimal("19.99"), new BigDecimal("9.99"), new BigDecimal("15.99"),
			new BigDecimal("3.99"), new BigDecimal("4.99") };
	static final int[] units = { 12, 8, 13, 29, 50 };
	static final String[] descs = { "Java T-shirt", "Java Mug", "Duke Juggling Dolls", "Java Pin", "Java Key Chain" };

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));

			out.writeObject(Calendar.getInstance());
			for (int i = 0; i < prices.length; i++) {
				out.writeObject(prices[i]);
				out.writeInt(units[i]);
				out.writeUTF(descs[i]);
			}
		} finally {
			out.close();
		}

		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)));

			Calendar date = null;
			BigDecimal price;
			int unit;
			String desc;
			BigDecimal total = new BigDecimal(0);

			date = (Calendar) in.readObject();

			System.out.format("On %tA, %<tB %<te, %<tY:%n", date);

			try {
				while (true) {
					price = (BigDecimal) in.readObject();
					unit = in.readInt();
					desc = in.readUTF();
					System.out.format("You ordered %d units of %s at $%.2f%n", unit, desc, price);
					total = total.add(price.multiply(new BigDecimal(unit)));
				}
			} catch (EOFException e) {
			}
			System.out.format("For a TOTAL of: $%.2f%n", total);
		} finally {
			in.close();
		}
	}
}
