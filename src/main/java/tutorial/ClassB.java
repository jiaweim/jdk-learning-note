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

package tutorial;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 01 May 2018, 7:50 PM
 */
public class ClassB
{
    private String id;

    private List<ClassA> list;

    public ClassB(String id)
    {
        this.id = id;
        list = new ArrayList<>();
    }

    public static void main(String[] args)
    {
        ClassB b1 = new ClassB("1");

        List<ClassB> listb = new ArrayList<>();

        b1.setList(Arrays.asList(new ClassA(1), new ClassA(2), new ClassA(3)));
        listb.add(b1);

        b1.setList(Arrays.asList(new ClassA(2), new ClassA(3), new ClassA(4)));
        listb.add(b1);

        for (ClassB b : listb) {
            System.out.println(b.getId());
            List<ClassA> list = b.getList();
            for (ClassA classA : list) {
                System.out.print(classA + ",");
            }
            System.out.println();
        }

    }

    public String getId()
    {
        return id;
    }

    public List<ClassA> getList()
    {
        return list;
    }

    public void setList(List<ClassA> list)
    {
        this.list = list;
    }
}
