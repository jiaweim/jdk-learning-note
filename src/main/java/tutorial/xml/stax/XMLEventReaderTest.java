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

import org.testng.annotations.Test;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.testng.Assert.*;

/**
 * @author JiaweiMao
 * @date Jan 16, 2016 8:28:45 PM
 */
public class XMLEventReaderTest
{
    @Test
    public void testEvent() throws XMLStreamException
    {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader reader = factory.createXMLEventReader(XMLEventReaderTest.class.getClassLoader().getResourceAsStream("bookstore.xml"));

        XMLEvent event = reader.peek();
        assertEquals(event.getEventType(), XMLStreamConstants.START_DOCUMENT);
        assertEquals(reader.nextEvent().getEventType(), XMLStreamConstants.START_DOCUMENT);

        reader.close();

//        XMLEvent event = reader.nextEvent();
//        assertEquals(event.getEventType(), XMLStreamConstants.START_DOCUMENT);
//        event = reader.nextEvent();
//        assertEquals(event.getEventType(), XMLStreamConstants.START_ELEMENT);
//        event = reader.nextEvent();
//        System.out.println(event.getEventType());
//
//
////        StartElement startElement = event.asStartElement();
////        assertEquals(startElement.getName().getLocalPart(), "bookstore");
//
//        System.out.println();

    }

//
//    public static void main(String[] args) throws XMLStreamException, FileNotFoundException
//    {
//        FileReader reader1 = new FileReader("E:/FileFormat/20131216-hela.mzML");
//
//        while (reader.hasNext()) {
//            XMLEvent event = reader.nextEvent();
//
//            if (event.isStartElement()) {
//                StartElement startElement = event.asStartElement();
//                String elementName = startElement.getName().toString();
//                System.out.println(elementName);
//            }
//        }
//    }
}
