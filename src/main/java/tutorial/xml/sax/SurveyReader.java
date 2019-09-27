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
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * 
 * @author JiaweiM
 * @date Oct 17, 2015 3:36:41 PM
 */
public class SurveyReader extends DefaultHandler {

	public SurveyReader() {
		System.out.println("Object Created.");
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Tallying survey results…");
		indent = -4;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName == "response"){
			System.out.println("User:"+attributes.getValue("username"));
		}else if(qName == "question"){
			thisQuestion = attributes.getValue("subject");
		}
		
		thisElement = qName;
		
		indent = indent + 4;
		printIndent(indent);

		System.out.print("Start element:");
		System.out.println(qName);

		for (int att = 0; att < attributes.getLength(); att++) {
			printIndent(indent + 4);;
			String attName = attributes.getQName(att);
			System.out.println(" " + attName + ":" + attributes.getValue(attName));
		}
	}

	String thisQuestion = "";
	String thisElement = "";
	
	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		if(thisElement == "question"){
			printIndent(4);
			System.out.print(thisQuestion+":");
			System.out.println(new String(ch, start, length));
		}
	}

	public void printIndent(int indentSize) {
		for (int s = 0; s < indentSize; s++) {
			System.out.print(" ");
		}
	}

	int indent = 0;

	public void endElement(String uri, String localName, String qName) throws SAXException {
		thisQuestion = "";
		thisElement = "";
		
		printIndent(indent);
		System.out.println("End Element:" + localName);
		indent = indent - 4;
	}

	public void showEvent(String name) {
		System.out.println("Hello, " + name + "!");
	}

	public static void main(String[] args) {
		SurveyReader reader = new SurveyReader();

		XMLReader xmlReader = null;
		try {
			SAXParserFactory spFactory = SAXParserFactory.newInstance();
			spFactory.setValidating(false);
			SAXParser saxParser = spFactory.newSAXParser();
			xmlReader = saxParser.getXMLReader();
			
			
			xmlReader.setContentHandler(new SurveyReader());
			xmlReader.setErrorHandler(new SurveyReader());

			InputSource source = new InputSource(SurveyReader.class.getResource("surveys.xml").getFile());
			xmlReader.parse(source);
		} catch (Exception e) {
			System.err.println(e);;
			System.exit(1);
		}
	}
}
