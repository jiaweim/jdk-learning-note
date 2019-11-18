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

package trail;

public class Main
{

    public static void main(String[] args)
    {
        // write your code here
        int COUNT_BITS = Integer.SIZE - 3;
        System.out.println(COUNT_BITS);
        int CAPACITY = (1 << COUNT_BITS) - 1;
        System.out.println(CAPACITY);
        int RUNNING = -1 << COUNT_BITS;
        System.out.println(RUNNING);
        int SHUTDOWN = 0 << COUNT_BITS;
        int STOP = 1 << COUNT_BITS;
        int TIDYING = 2 << COUNT_BITS;
        int TERMINATED = 3 << COUNT_BITS;

    }
}
