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

package test.jdk.xml.jaxb.adapter;

import test.jdk.xml.jaxb.Country;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.time.LocalDate;

/**
 * Simple example of usage of jaxb marshaling functionalities when managing complex classes, in this
 * case java.time.LocalDate
 *
 * @author dgutierrez-diez
 */
public class JaxBExampleAdapter {

    public static void main(String[] args) {
        try {

            /* init very simple data to marshal */
            Country country = new Country();
            country.setName("Spain");
            country.setCapital("Madrid");
            country.setContinent("Europe");


            country.setFoundation(LocalDate.of(1469, 10, 19));

            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal(country, new File("country_adapter.xml"));
            jaxbMarshaller.marshal(country, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
