package mjw.study.jdk.xml.stax;

import org.junit.jupiter.api.Test;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author JiaweiMao 2017.04.10
 * @since 1.0-SNAPSHOT
 */
public class XMLStreamWriterTest
{

    /**
     * This is a simple example that illustrates how to use the
     * the XMLStreamWriter class to generate XML.
     * <p>
     * The generated XML file looks like this:
     * <p>
     * <?xml version='1.0' encoding='utf-8'?>
     * <p>
     * <!--this is a comment-->
     * <person xmlns:one="http://namespaceOne" gender="f">
     * <one:name hair="pigtails" freckles="yes">Pippi Longstocking</one:name>
     * </person>
     */
    @Test
    void test() throws FileNotFoundException, XMLStreamException
    {
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter xmlw = outputFactory.createXMLStreamWriter(new FileOutputStream("output.xml"));

        // generate xml
        // Write the default XML declaration
        xmlw.writeStartDocument();
        xmlw.writeCharacters("\n");
        xmlw.writeCharacters("\n");
        // Write a comment
        xmlw.writeComment("this is a comment");
        xmlw.writeCharacters("\n");
        // Write the root element "person" with a single attribute "gender"
        xmlw.writeStartElement("person");
        xmlw.writeNamespace("one", "http://namespaceOne");
        xmlw.writeAttribute("gender", "f");
        xmlw.writeCharacters("\n");
        // Write the "name" element with some content and two attributes
        xmlw.writeCharacters("    ");
        xmlw.writeStartElement("one", "name", "http://namespaceOne");
        xmlw.writeAttribute("hair", "pigtails");
        xmlw.writeAttribute("freckles", "yes");
        xmlw.writeCharacters("Pippi Longstocking");
        // End the "name" element
        xmlw.writeEndElement();
        xmlw.writeCharacters("\n");
        // End the "person" element
        xmlw.writeEndElement();
        // End the XML document
        xmlw.writeEndDocument();
        // Close the XMLStreamWriter to free up resources
        xmlw.close();
    }

}
