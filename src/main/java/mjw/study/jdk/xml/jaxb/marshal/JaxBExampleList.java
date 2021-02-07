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

package mjw.study.jdk.xml.jaxb.marshal;

import mjw.study.jdk.xml.jaxb.Countries;
import mjw.study.jdk.xml.jaxb.Country;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.time.LocalDate;


/**
 * Simple example of usage of jaxb marshaling functionalities showing how to manage lists
 *
 * @author dgutierrez-diez
 */
public class JaxBExampleList {

    public static void main(String[] args) {
        try {

            /* init a list with a couple of countries to marshal */
            Country spain = new Country();
            spain.setName("Spain");
            spain.setCapital("Madrid");
            spain.setContinent("Europe");

            spain.setFoundation(LocalDate.of(1469, 10, 19));

            Country usa = new Country();
            usa.setName("USA");
            usa.setCapital("Washington");
            usa.setContinent("America");
            usa.setFoundation(LocalDate.of(1776, 7, 4));

            Countries countries = new Countries();
            countries.add(spain);
            countries.add(usa);

            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance(Countries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal(countries, new File("list_countries.xml"));
            jaxbMarshaller.marshal(countries, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
