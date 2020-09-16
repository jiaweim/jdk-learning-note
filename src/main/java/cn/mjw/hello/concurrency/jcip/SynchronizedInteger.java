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

import cn.mjw.hello.concurrency.jcip.annotations.GuardedBy;
import cn.mjw.hello.concurrency.jcip.annotations.ThreadSafe;

/**
 * Thread-safe mutable integer holder
 *
 * @author JiaweiMao 2017-05-05
 * @since 1.0-SNAPSHOT
 */
@ThreadSafe
public class SynchronizedInteger {

    @GuardedBy("this") private int value;
    public synchronized int get() {
        return value;
    }

    public synchronized void set(int value) {
        this.value = value;
    }
}
