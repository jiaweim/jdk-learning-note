package mjw.study.jdk.xml.stax;

import org.junit.jupiter.api.Test;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.io.StringWriter;

/**
 * @author JiaweiMao 2017.04.05
 * @since 1.0-SNAPSHOT
 */
class XMLEventTest
{
    @Test
    void writeAsEncodedUnicode() throws XMLStreamException
    {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader eventReader = factory.createXMLEventReader(XMLEventTest.class.getClassLoader()
                .getResourceAsStream("input.xml"));

        StringWriter writer = new StringWriter();

        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
            event.writeAsEncodedUnicode(writer);
        }

        writer.flush();
        String resultingXml = writer.toString();
        System.out.println(resultingXml);
//        assertTrue("XMLEvent.writeAsEncodedUnicode() is working.\n" + resultingXml,
//                resultingXml.equals(""));

    }
}
