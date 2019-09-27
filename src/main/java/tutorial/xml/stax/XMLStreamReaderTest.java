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

package tutorial.xml.stax;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

import static org.testng.Assert.*;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.25, 7:06 PM
 */
public class XMLStreamReaderTest {
	private XMLStreamReader reader;

	@Test
	void testNext() throws XMLStreamException {
		assertEquals(XMLStreamConstants.START_ELEMENT, reader.next());
		assertEquals(XMLStreamConstants.START_ELEMENT, reader.getEventType());

		assertEquals(1, reader.getAttributeCount());
		assertEquals("books.xsd", reader.getAttributeValue(0));
		assertEquals("noNamespaceSchemaLocation", reader.getAttributeLocalName(0));
		System.out.println();

		assertEquals("{http://www.w3.org/2001/XMLSchema-instance}noNamespaceSchemaLocation",
				reader.getAttributeName(0).toString());
		assertEquals("http://www.w3.org/2001/XMLSchema-instance", reader.getAttributeNamespace(0));
		assertEquals("xsi", reader.getAttributePrefix(0));
		assertEquals("CDATA", reader.getAttributeType(0));
		assertEquals("UTF-8", reader.getCharacterEncodingScheme());
		assertEquals("UTF-8", reader.getEncoding());
		assertEquals(2, reader.getLocation().getLineNumber());
		assertEquals("books", reader.getName().toString());
		assertEquals(1, reader.getNamespaceCount());
		assertEquals("xsi", reader.getNamespacePrefix(0));
		assertNull(reader.getNamespaceURI());
		assertFalse(reader.hasText());
		assertTrue(reader.hasNext());

		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());
		assertTrue(reader.isWhiteSpace());

		// start of book
		assertEquals(XMLStreamConstants.START_ELEMENT, reader.next());
		assertEquals("book", reader.getLocalName());

		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());
		assertTrue(reader.isWhiteSpace());

		// name element
		assertEquals(XMLStreamConstants.START_ELEMENT, reader.next());
		assertEquals("name", reader.getLocalName());

		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());
		assertEquals("《水浒传》", reader.getText());

		assertEquals(XMLStreamConstants.END_ELEMENT, reader.next());
		assertEquals("name", reader.getLocalName());

		// whitespace
		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());
		assertTrue(reader.isWhiteSpace());

		// price element
		assertEquals(XMLStreamConstants.START_ELEMENT, reader.next());
		assertEquals("price", reader.getLocalName());

		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());
		assertEquals("80", reader.getText());

		assertEquals(XMLStreamConstants.END_ELEMENT, reader.next());
		assertEquals("price", reader.getLocalName());

		// whitespace
		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());
		assertTrue(reader.isWhiteSpace());

		// author element
		assertEquals(XMLStreamConstants.START_ELEMENT, reader.next());
		assertEquals("author", reader.getLocalName());

		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());
		assertEquals("施耐庵", reader.getText());

		assertEquals(XMLStreamConstants.END_ELEMENT, reader.next());
		assertEquals("author", reader.getLocalName());

		// whitespace
		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());
		assertTrue(reader.isWhiteSpace());

		// year element
		assertEquals(XMLStreamConstants.START_ELEMENT, reader.next());
		assertEquals("year", reader.getLocalName());

		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());
		assertEquals("元末", reader.getText());

		assertEquals(XMLStreamConstants.END_ELEMENT, reader.next());
		assertEquals("year", reader.getLocalName());

		// whitespace
		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());
		assertTrue(reader.isWhiteSpace());

		// end of book
		assertEquals(XMLStreamConstants.END_ELEMENT, reader.next());
		assertEquals("book", reader.getLocalName());

		// whitespace
		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());
		assertTrue(reader.isWhiteSpace());

		// start of another book
		assertEquals(XMLStreamConstants.START_ELEMENT, reader.next());
		assertEquals("book", reader.getLocalName());

		// whitespace
		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());

		// name
		assertEquals(XMLStreamConstants.START_ELEMENT, reader.next());
		// 《西游记》
		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());
		// end of name
		assertEquals(XMLStreamConstants.END_ELEMENT, reader.next());

		// whitespace
		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());

		// price
		assertEquals(XMLStreamConstants.START_ELEMENT, reader.next());
		// 90
		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());
		// end of price
		assertEquals(XMLStreamConstants.END_ELEMENT, reader.next());

		// whitespace
		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());

		// author
		assertEquals(XMLStreamConstants.START_ELEMENT, reader.next());
		// 吴承恩
		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());
		// end of author
		assertEquals(XMLStreamConstants.END_ELEMENT, reader.next());

		// whitespace
		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());

		// year
		assertEquals(XMLStreamConstants.START_ELEMENT, reader.next());
		// 明代
		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());
		// end of year
		assertEquals(XMLStreamConstants.END_ELEMENT, reader.next());

		// whitespace
		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());

		// end of book
		assertEquals(XMLStreamConstants.END_ELEMENT, reader.next());

		// whitespace
		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());

		// end of books
		assertEquals(XMLStreamConstants.END_ELEMENT, reader.next());

		// end of document
		assertEquals(XMLStreamConstants.END_DOCUMENT, reader.next());

		// assertEquals("《水浒传》", reader.getText());
		// assertTrue(reader.isWhiteSpace());

		// out.println(reader.next());
		// out.println(reader.getLocalName());
		// out.print(reader.getText());
	}

	@Test
	void testNextTag() throws XMLStreamException {
		// start of books
		assertEquals(XMLStreamConstants.START_ELEMENT, reader.nextTag());
		assertEquals("books", reader.getLocalName());

		// start of book
		assertEquals(XMLStreamConstants.START_ELEMENT, reader.nextTag());
		assertEquals("book", reader.getLocalName());

		// start of name
		assertEquals(XMLStreamConstants.START_ELEMENT, reader.nextTag());
		assertEquals("name", reader.getLocalName());

		// 《水浒传
		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());

		// end of name
		assertEquals(XMLStreamConstants.END_ELEMENT, reader.nextTag());
		assertEquals("name", reader.getLocalName());

		// start of price
		assertEquals(XMLStreamConstants.START_ELEMENT, reader.nextTag());
		assertEquals("price", reader.getLocalName());

		// 80
		assertEquals(XMLStreamConstants.CHARACTERS, reader.next());

		// end of price
		assertEquals(XMLStreamConstants.END_ELEMENT, reader.nextTag());
		assertEquals("price", reader.getLocalName());
	}

	@BeforeMethod
	void setUp() throws XMLStreamException {
		InputStream is = XMLStreamReaderTest.class.getClassLoader().getResourceAsStream("book2.xml");
		XMLInputFactory factory = XMLInputFactory.newInstance();
		reader = factory.createXMLStreamReader(is);
	}

	@Test
	void test() throws XMLStreamException {
		while (reader.hasNext()) {
			int event = reader.next();
			if (event == XMLStreamConstants.START_ELEMENT) {
				// if (reader.getLocalName().equals("name")) {
				// reader.next();
				// System.out.println(reader.getText());
				// }

			}
			if (event == XMLStreamConstants.CHARACTERS) {
				System.out.println(reader.getText());
			}
		}
	}
}
