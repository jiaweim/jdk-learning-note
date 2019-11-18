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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * JaxB is not capable of marshal lists directly as root elements, so we need a container for the
 * list of countries. Getter and Setter are used by jaxb
 *
 * @author dgutierrez-diez
 */
@XmlRootElement(name = "Countries")
public class Countries {
    List<Country> countries;

    public List<Country> getCountries() {
        return countries;
    }

    /**
     * element that is going to be marshaled in the xml
     */
    @XmlElement(name = "Country")
    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    /**
     * This method is not used by jaxb, just used for business reasons. In the case that this class
     * would be generated using xml schemas definitions, this method has to be added to the
     * generated class or to some helper or util one
     *
     * @param country
     */
    public void add(Country country) {
        if (this.countries == null) {
            this.countries = new ArrayList<>();
        }
        this.countries.add(country);

    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (Country museum : this.countries) {
            str.append(museum.toString());
        }
        return str.toString();
    }

}
