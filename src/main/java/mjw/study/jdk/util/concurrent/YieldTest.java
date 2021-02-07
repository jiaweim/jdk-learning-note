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

package mjw.study.jdk.util.concurrent;

/**
 * @author JiaweiMao on 2017.05.23
 * @since 1.0-SNAPSHOT
 */
public class YieldTest extends Thread {

    public YieldTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 50; i++) {
            System.out.println(this.getName() + "------" + i);
            if (i == 30)
                Thread.yield();
        }
    }

    public static void main(String[] args) {
        YieldTest t1 = new YieldTest("张三");
        YieldTest t2 = new YieldTest("李四");
        t1.start();
        t2.start();
    }
}
