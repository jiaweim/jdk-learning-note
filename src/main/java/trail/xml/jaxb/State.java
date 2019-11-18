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

package trail.xml.jaxb;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author JiaweiMao 2017.04.11
 * @since 1.0-SNAPSHOT
 */
@XmlRootElement(namespace = "test.jdk.xml.jaxb.Nation")
public class State {

    public State() {
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public long getStatePopulation() {
        return statePopulation;
    }

    public void setStatePopulation(long statePopulation) {
        this.statePopulation = statePopulation;
    }

    private String stateName;
    long statePopulation;

    public State(String stateName, long statePopulation) {
        this.stateName = stateName;
        this.statePopulation = statePopulation;
    }
}
