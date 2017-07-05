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

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileReader;

public class Parse {
    private static String filename = null;

    private static void printUsage() {
        System.out.println("usage: java examples.basic.Parse <xmlfile>");
    }

    public static void main(String[] args) throws Exception {
        try {
            filename = args[0];
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            printUsage();
            System.exit(0);
        }
        //
        // Get an input factory
        //
        XMLInputFactory xmlif = XMLInputFactory.newInstance();
        System.out.println("FACTORY: " + xmlif);
        //
        // Instantiate a reader
        //
        XMLStreamReader xmlr = xmlif.createXMLStreamReader(new FileReader(filename));
        System.out.println("READER:  " + xmlr + "\n");
        //
        // Parse the XML
        //
        while (xmlr.hasNext()) {
            printEvent(xmlr);
            xmlr.next();
        }
        //
        // Close the reader
        //
        xmlr.close();
    }

    private static void printEvent(XMLStreamReader xmlr) {
        System.out.print("EVENT:[" + xmlr.getLocation().getLineNumber() + "][" + xmlr.getLocation().getColumnNumber()
                + "] ");
        System.out.print(" [");

        switch (xmlr.getEventType()) {
            case XMLStreamConstants.START_ELEMENT:
                System.out.print("<");
                printName(xmlr);
                printNamespaces(xmlr);
                printAttributes(xmlr);
                System.out.print(">");
                break;
            case XMLStreamConstants.END_ELEMENT:
                System.out.print("</");
                printName(xmlr);
                System.out.print(">");
                break;
            case XMLStreamConstants.SPACE:
            case XMLStreamConstants.CHARACTERS:
                int start = xmlr.getTextStart();
                int length = xmlr.getTextLength();
                System.out.print(new String(xmlr.getTextCharacters(),
                        start,
                        length));
                break;
            case XMLStreamConstants.PROCESSING_INSTRUCTION:
                System.out.print("<?");
                if (xmlr.hasText())
                    System.out.print(xmlr.getText());
                System.out.print("?>");
                break;
            case XMLStreamConstants.CDATA:
                System.out.print("<![CDATA[");
                start = xmlr.getTextStart();
                length = xmlr.getTextLength();
                System.out.print(new String(xmlr.getTextCharacters(),
                        start,
                        length));
                System.out.print("]]>");
                break;
            case XMLStreamConstants.COMMENT:
                System.out.print("<!--");
                if (xmlr.hasText())
                    System.out.print(xmlr.getText());
                System.out.print("-->");
                break;
            case XMLStreamConstants.ENTITY_REFERENCE:
                System.out.print(xmlr.getLocalName() + "=");
                if (xmlr.hasText())
                    System.out.print("[" + xmlr.getText() + "]");
                break;
            case XMLStreamConstants.START_DOCUMENT:
                System.out.print("<?xml");
                System.out.print(" version='" + xmlr.getVersion() + "'");
                System.out.print(" encoding='" + xmlr.getCharacterEncodingScheme() + "'");
                if (xmlr.isStandalone())
                    System.out.print(" standalone='yes'");
                else
                    System.out.print(" standalone='no'");
                System.out.print("?>");
                break;
        }
        System.out.println("]");
    }

    /**
     * get the name information of element:
     * full name = prefix + namespace URI + local name
     */
    private static void printName(XMLStreamReader xmlr) {
        if (xmlr.hasName()) {
            String prefix = xmlr.getPrefix();
            String uri = xmlr.getNamespaceURI();
            String localName = xmlr.getLocalName();
            printName(prefix, uri, localName);
        }
    }

    private static void printName(String prefix, String uri, String localName) {
        if (uri != null && !("".equals(uri)))
            System.out.print("['" + uri + "']:");
        if (prefix != null)
            System.out.print(prefix + ":");
        if (localName != null)
            System.out.print(localName);
    }

    /**
     * getAttributeXXX() methods only on start element, end element, and attribute events.
     *
     * getAttributeCount(), return the number of attributes of the current element
     */
    private static void printAttributes(XMLStreamReader xmlr) {
        for (int i = 0; i < xmlr.getAttributeCount(); i++) {
            printAttribute(xmlr, i);
        }
    }

    private static void printAttribute(XMLStreamReader xmlr, int index) {
        String prefix = xmlr.getAttributePrefix(index);
        String namespace = xmlr.getAttributeNamespace(index);
        String localName = xmlr.getAttributeLocalName(index);
        String value = xmlr.getAttributeValue(index);
        System.out.print(" ");
        printName(prefix, namespace, localName);
        System.out.print("='" + value + "'");
    }

    private static void printNamespaces(XMLStreamReader xmlr) {
        for (int i = 0; i < xmlr.getNamespaceCount(); i++) {
            printNamespace(xmlr, i);
        }
    }

    private static void printNamespace(XMLStreamReader xmlr, int index) {
        String prefix = xmlr.getNamespacePrefix(index);
        String uri = xmlr.getNamespaceURI(index);
        System.out.print(" ");
        if (prefix == null)
            System.out.print("xmlns='" + uri + "'");
        else
            System.out.print("xmlns:" + prefix + "='" + uri + "'");
    }
}