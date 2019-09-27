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

package tutorial.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 * 
 * @Class	ContentHandlerTest
 * @author	JiaweiM
 * @date	Aug 13, 2015 10:53:54 AM
 */
public class ContentHandlerTest implements ContentHandler{

	StringBuffer buffer;
	int frontBlankCount = 0;

	public ContentHandlerTest() {
		buffer = new StringBuffer();
	}

	/*
	 * (non-Javadoc)
	 * @see org.xml.sax.ContentHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		StringBuffer buffer = new StringBuffer();
		for (int i = start; i < start + length; i++) {
			switch (ch[i]) {
				case '\\':
					buffer.append("\\\\");
					break;
				case '\r':
					buffer.append("\\r");
					break;
				case '\n':
					buffer.append("\\n");
					break;
				case '\t':
					buffer.append("\\t");
					break;
				case '\"':
					buffer.append("\\\"");
					break;
				default:
					buffer.append(ch[i]);
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * @see org.xml.sax.ContentHandler#endDocument()
	 */
	@Override
	public void endDocument() throws SAXException {
		System.out.println(this.toBlackString(--this.frontBlankCount) + ">>> end document");
	}

	/*
	 * (non-Javadoc)
	 * @see org.xml.sax.ContentHandler#endElement(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(this.toBlackString(--this.frontBlankCount) + ">>> end element : " + qName + "("
				+ uri + ")");
	}

	/*
	 * (non-Javadoc)
	 * @see org.xml.sax.ContentHandler#endPrefixMapping(java.lang.String)
	 */
	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		System.out.println(this.toBlackString(--this.frontBlankCount) + ">>> end prefix_mapping : " + prefix);
	}

	/*
	 * (non-Javadoc)
	 * @see org.xml.sax.ContentHandler#ignorableWhitespace(char[], int, int)
	 */
	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		StringBuffer buffer = new StringBuffer();
		for (int i = start; i < start + length; i++) {
			switch (ch[i]) {
				case '\\':
					buffer.append("\\\\");
					break;
				case '\r':
					buffer.append("\\r");
					break;
				case '\n':
					buffer.append("\\n");
					break;
				case '\t':
					buffer.append("\\t");
					break;
				case '\"':
					buffer.append("\\\"");
					break;
				default:
					buffer.append(ch[i]);
			}
		}
		System.out.println(this.toBlackString(this.frontBlankCount) + ">>> ignorable whitespace(" + length
				+ "): " + buffer.toString());
	}

	/*
	 * (non-Javadoc)
	 * @see org.xml.sax.ContentHandler#processingInstruction(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		System.out.println(this.toBlackString(this.frontBlankCount) + ">>> process instruction : (" + target
				+ "\",data=\"" + data + "\")");
	}

	/*
	 * (non-Javadoc)
	 * @see org.xml.sax.ContentHandler#setDocumentLocator(org.xml.sax.Locator)
	 */
	@Override
	public void setDocumentLocator(Locator locator) {

	}

	/*
	 * (non-Javadoc)
	 * @see org.xml.sax.ContentHandler#skippedEntity(java.lang.String)
	 */
	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see org.xml.sax.ContentHandler#startDocument()
	 */
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see org.xml.sax.ContentHandler#startElement(java.lang.String,
	 * java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see org.xml.sax.ContentHandler#startPrefixMapping(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		// TODO Auto-generated method stub

	}

	private String toBlackString(int count) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < count; i++) {
			buffer.append(" ");
		}
		return buffer.toString();
	}

}
