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
 * @version 1.00
 */

package cn.mjw.hello.xml.validation;

import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author JiaweiM
 * @date Aug 29, 2015 4:30:45 PM
 */
public class SchemaValidation
{
    public static void main(String[] args)
    {
        // 1. Lookup a factory for the W3C XML Schema language
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        // 2. Compile the schema.
        URL schemaLocation;
        // get the schema file
        schemaLocation = SchemaValidation.class.getResource("mzML1.1.1-idx.xsd");
        assertNotNull(schemaLocation);

        Schema schema;
        try {
            schema = factory.newSchema(schemaLocation);
        } catch (SAXException e) {
            e.printStackTrace();
            throw new IllegalStateException("Could not compile Schema for file: " + schemaLocation);
        }

        // 3. Get a validator from the schema.
        Validator validator = schema.newValidator();

        // 4. Parse the xml document you want to check.
        Source source = new StreamSource("");

        boolean valid;
        // 5. Check the document
        try {
            validator.validate(source);
            valid = true;
        } catch (SAXException ex) {
            valid = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
