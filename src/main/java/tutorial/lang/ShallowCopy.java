/*
 * Copyright 2018 JiaweiMao jiaweiM_philo@hotmail.com
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

package tutorial.lang;

import java.util.Date;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 17 Oct 2019, 11:30 AM
 */
public class ShallowCopy implements Cloneable
{
    private Date begin;

    public Date getBegin()
    {
        return this.begin;
    }

    public void setBegin(Date d)
    {
        this.begin = d;
    }

    public ShallowCopy clone()
    {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return (ShallowCopy) obj;
    }

    public static void main(String[] args)
    {
        Date date = new Date(10000L);
        ShallowCopy copy = new ShallowCopy();
        copy.setBegin(date);
        ShallowCopy copy2 = copy.clone();
        System.out.println(copy.getBegin() + "\n" + copy2.getBegin() + "\n" + (copy == copy2));
        date.setTime(100000000L);
        System.out.println(copy.getBegin() + "\n" + copy2.getBegin() + "\n" + (copy == copy2));
    }
}
