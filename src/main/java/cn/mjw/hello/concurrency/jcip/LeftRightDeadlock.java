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

package cn.mjw.hello.concurrency.jcip;

/**
 * Simple lock-ordering deadlock
 * <p>
 * 两个线程试图以不同的顺序获得相同的锁。
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 18 Jan 2019, 6:23 PM
 */
public class LeftRightDeadlock
{
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight()
    {
        synchronized (left) {
            synchronized (right) {
                doSomething();
            }
        }
    }

    void doSomething()
    {
        synchronized (right) {
            synchronized (left) {
                doSomethingElse();
            }
        }
    }

    void doSomethingElse()
    {
    }
}
