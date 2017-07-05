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

package test.jdk.math;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author JiaweiMao 2017-05-02
 * @since 1.0-SNAPSHOT
 */
class BigDecimalTest {

    @Test
    void setScale(){
        BigDecimal decimal = new BigDecimal("5.196469");
        decimal = decimal.setScale(0, BigDecimal.ROUND_HALF_UP);
        System.out.println(decimal.doubleValue());
    }

}
