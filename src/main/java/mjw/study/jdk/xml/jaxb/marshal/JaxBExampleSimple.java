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

import mjw.study.jdk.xml.jaxb.Country;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.time.LocalDate;

/**
 * Simple example of usage of jaxb marshaling functionalities
 *
 * @author dgutierrez-diez
 */
public class JaxBExampleSimple {

    public static void main(String[] args) {
        try {

            /* init very simple data to marshal */
            Country spain = new Country();
            spain.setName("Spain");
            spain.setCapital("Madrid");
            spain.setContinent("Europe");
            spain.setFoundation(LocalDate.of(1469, 10, 19));


            spain.setPopulation(45000000);

            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal(spain, new File("country.xml"));
            jaxbMarshaller.marshal(spain, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
