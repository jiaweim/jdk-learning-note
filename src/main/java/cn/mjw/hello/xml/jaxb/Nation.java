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

package cn.mjw.hello.xml.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

/**
 * @author JiaweiMao 2017.04.11
 * @since 1.0-SNAPSHOT
 */
@XmlRootElement
@XmlType(propOrder = {"nationName", "nationPopulation", "listOfStates"})
public class Nation {

    public Nation() {
    }

    public String getNationName() {
        return nationName;
    }

    @XmlElement
    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    public double getNationPopulation() {
        return nationPopulation;
    }

    @XmlElement
    public void setNationPopulation(long nationPopulation) {
        this.nationPopulation = nationPopulation;
    }

    public ArrayList<State> getListOfStates() {
        return listOfStates;
    }

    @XmlElementWrapper(name = "stateList")
    @XmlElement(name = "state")
    public void setListOfStates(ArrayList<State> listOfStates) {
        this.listOfStates = listOfStates;
    }

    private String nationName;
    private long nationPopulation;
    private ArrayList<State> listOfStates;
}
