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

package tutorial.xml.jaxb;

import tutorial.xml.jaxb.adapter.DateAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

/**
 * Country containing a name, a capital city, a foundation date and the continent it belongs to,
 * these attributes are going to be represented in this order in the generated XML as described in
 * the annotation XmlType
 *
 * @author dgutierrez-diez
 */
@XmlType(propOrder = {"name", "capital", "foundation", "continent", "population"})
@XmlRootElement(name = "Country")
public class Country {

    String name;
    String capital;
    LocalDate foundation;
    String continent;
    int population;

    public int getPopulation() {
        return population;
    }

    @XmlElement(name = "Country_Population")
    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "Country_Name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer("Name: " + getName() + "\n");
        str.append("Capital: " + getCapital() + "\n");

        if (getFoundation() != null) {
            str.append(getFoundation().toString());
            str.append("\n");
        }

        if (getContinent() != null) {
            str.append(getContinent().toString());
            str.append("\n");
        }

        return str.toString();
    }

    public String getCapital() {
        return capital;
    }

    @XmlElement(name = "Country_Capital")
    public void setCapital(String capital) {
        this.capital = capital;
    }

    public LocalDate getFoundation() {
        return foundation;
    }

    @XmlElement(name = "Country_Foundation_Date")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setFoundation(LocalDate foundation) {
        this.foundation = foundation;
    }

    public String getContinent() {
        return continent;
    }

    @XmlElement(name = "Country_Continent")
    public void setContinent(String continent) {
        this.continent = continent;
    }
}
