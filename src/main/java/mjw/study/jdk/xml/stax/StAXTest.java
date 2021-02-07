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

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author JiaweiMao
 * @date Jan 16, 2016 2:28:45 PM
 */
public class StAXTest {

	public static void main(String[] args) throws XMLStreamException, IOException {
		String urlString;
		if (args.length == 0) {
			urlString = "http://www.w3c.org";
			System.out.println("Using " + urlString);
		} else
			urlString = args[0];

		URL url = new URL(urlString);
		InputStream io = url.openStream();
		XMLInputFactory factory = XMLInputFactory.newInstance();
		factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, factory);
		
		XMLStreamReader parser = factory.createXMLStreamReader(io);
		while (parser.hasNext()) {
			int event = parser.next();
			if (event == XMLStreamConstants.START_ELEMENT) {
				if (parser.getLocalName().equals("a")) {
					String href = parser.getAttributeValue(null, "href");
					if (href != null) {
						System.out.println(href);
					}
				}
			}
		}
	}
}
