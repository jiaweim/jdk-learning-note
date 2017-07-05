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

package test.jdk.xml.jaxb.unmarshal;

import test.jdk.xml.jaxb.Countries;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * This class shows how to unmarshall a simple XML structure into java classes
 *
 * @author dgutierrez-diez
 */
public class UnMarshalJAXVBCompleteExample {
    public static void main(String[] args) {

        try {

            File file = new File("countries.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Countries.class);

            /*
             * the only difference with the marshaling operation is here
             */
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Countries countres = (Countries) jaxbUnmarshaller.unmarshal(file);
            System.out.println(countres);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
