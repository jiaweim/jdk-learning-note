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

package test.jdk.xml.jaxb.marshal;

import test.jdk.xml.jaxb.Nation;
import test.jdk.xml.jaxb.State;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;

/**
 * @author JiaweiMao 2017.04.11
 * @since 1.0-SNAPSHOT
 */
public class JAXBJava2Xml {

    public static void main(String[] args) {
        Nation nation = new Nation();
        nation.setNationName("India");
        nation.setNationPopulation(500000000);

        ArrayList<State> stateArrayList = new ArrayList<>();
        State aState = new State("Madhya Predesh", 1000000);
        State bState = new State("Maharastra", 2000000000);
        stateArrayList.add(aState);
        stateArrayList.add(bState);

        nation.setListOfStates(stateArrayList);

        try {
            JAXBContext context = JAXBContext.newInstance(Nation.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File xmlFile = new File("NationRecord.xml");
            marshaller.marshal(nation, xmlFile);
            marshaller.marshal(nation, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
