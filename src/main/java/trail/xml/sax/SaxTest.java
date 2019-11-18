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

/**
 * 
 * @version 1.00
 */

package trail.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;


/**
 * 
 * @Class	SaxTest
 * @author	JiaweiM
 * @date	Aug 13, 2015 10:50:22 AM
 */
public class SaxTest {

	class BookHandler extends DefaultHandler {
		private List<String> nameList;
		private boolean title = false;

		public List<String> getNameList() {
			return nameList;
		}

		// Called at start of an XML document
		@Override
		public void startDocument() {
			System.out.println("Start parsing document...");

		}

		// Called at the end of an XML document
		@Override
		public void endDocument() {
			System.out.println("End");
		}

		/**
		 * Start processing of an element.
		 * 
		 * @param namespaceURI
		 *            Namespace URI
		 * @param localName
		 *            The local name, without prefix
		 * @param qName
		 *            The qualified name, with prefix
		 * @param atts
		 *            The attributes of the element
		 */
		@Override
		public void startElement(String uri, String localName, String qName, Attributes atts)
				throws SAXException {
			// Using qualified name because we are not using xmlns prefixes
			// here.
			if (qName.equals("title")) {
				title = true;
			}
		}

		@Override
		public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
			// End of processing current element
			if (title) {
				title = false;
			}
		}

		@Override
		public void characters(char[] ch, int start, int length) {
			// Processing character data inside an element
			if (title) {
				String bookTitle = new String(ch, start, length);
				System.out.println("Book title: " + bookTitle);
				nameList.add(bookTitle);
			}
		}
	}

	public static void main(String[] args) throws SAXException, IOException {
		XMLReader parser = XMLReaderFactory.createXMLReader();
		BookHandler bookHandler = (new SaxTest()).new BookHandler();
		parser.setContentHandler(bookHandler);
		parser.parse(SaxTest.class.getResource("book.xml").getPath());
		System.out.println(bookHandler.getNameList());
	}
}
