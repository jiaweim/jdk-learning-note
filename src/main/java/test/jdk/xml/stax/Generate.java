/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 JiaweiMao
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package test.jdk.xml.stax;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;

public class Generate {

    public static void main(String args[]) throws Exception {
        //
        // Get an output factory
        //
        XMLOutputFactory xmlof = XMLOutputFactory.newInstance();
        System.out.println("FACTORY: " + xmlof);
        //
        // Instantiate a writer
        //
        XMLStreamWriter xmlw = xmlof.createXMLStreamWriter(new FileOutputStream("outFile.xml"));
        System.out.println("READER:  " + xmlw + "\n");
        //
        // Generate the XML
        //
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