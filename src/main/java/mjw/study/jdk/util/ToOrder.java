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

package mjw.study.jdk.util;


/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 30 Nov 2017, 3:12 PM
 */
public class ToOrder
{
    private Integer v1;
    private String v2;
    private Double v3;

    public ToOrder(Integer v1, String v2, Double v3)
    {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public Integer getV1()
    {
        return v1;
    }

    public String getV2()
    {
        return v2;
    }

    public Double getV3()
    {
        return v3;
    }

    @Override
    public String toString()
    {
        return "ToOrder{" +
                "v1=" + v1 +
                ", v2='" + v2 + '\'' +
                ", v3=" + v3 +
                '}';
    }
}
