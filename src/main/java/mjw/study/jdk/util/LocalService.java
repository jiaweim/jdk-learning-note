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

package mjw.study.jdk.util;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 29 Jul 2018, 9:27 PM
 */
public class LocalService implements IService
{
    @Override
    public String sayHello()
    {
        return "Hello Local!!";
    }

    @Override
    public String getScheme()
    {
        return "local";
    }
}
