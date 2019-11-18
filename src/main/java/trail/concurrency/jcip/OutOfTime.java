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

package trail.concurrency.jcip;

import java.util.Timer;
import java.util.TimerTask;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 如果 TimerTask 抛出一个未检查的 异常，Timer 并不捕获异常而是终止线程，也不会恢复线程的执行，而是错误的认为整个 Timer
 * 都被取消了。因此被调度但尚未执行的 TimerTask 将会不再执行，新的任务也不能被调度。
 * <p>
 * 如下，程序运行 1 s 就退出了，而不是 6s。
 * 在java 5.0 之后已经很少使用 Timer 了。
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 18 Jan 2019, 4:15 PM
 */
public class OutOfTime {
    public static void main(String[] args) throws Exception {
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(), 1);
        SECONDS.sleep(1);

        timer.schedule(new ThrowTask(), 1);
        SECONDS.sleep(5);
    }

    static class ThrowTask extends TimerTask {
        public void run() {
            throw new RuntimeException();
        }
    }
}
