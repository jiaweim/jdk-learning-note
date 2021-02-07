package mjw.study.jdk.xml.stax;

import org.junit.jupiter.api.Test;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiMao
 * @date Jan 16, 2016 8:28:45 PM
 */
class XMLEventReaderTest
{
    @Test
    void testEvent() throws XMLStreamException
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
