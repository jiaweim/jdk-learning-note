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

package mjw.study.jdk.xml.stax;

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