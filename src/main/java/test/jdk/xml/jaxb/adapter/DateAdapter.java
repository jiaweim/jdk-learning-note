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

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

/**
 * This class adapts the LocalDate objects by implementing the XmlAdapter interface in order that
 * JaxB is capable of marshal and unmarshal them
 *
 * @author dgutierrez-diez
 */
public class DateAdapter extends XmlAdapter<String, LocalDate> {

    /**
     * Overrides the unmarshal method of the class XmlAdapter in order to parse a date of the type
     * LocalDate
     *
     * @param date String
     * @return LocalDate
     * @throws Exception
     */
    public LocalDate unmarshal(String date) throws Exception {
        return LocalDate.parse(date);
    }

    /**
     * Overrides the marshal method of the class XmlAdapter in order to convert the passed date to
     * an String
     *
     * @param date LocalDate
     * @return String
     * @throws Exception
     */
    public String marshal(LocalDate date) throws Exception {
        return date.toString();
    }

}
