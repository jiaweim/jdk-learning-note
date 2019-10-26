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

package tutorial.concurrency.jcip;

import tutorial.concurrency.jcip.annotations.GuardedBy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JiaweiMao on 2017.05.23
 * @since 1.0-SNAPSHOT
 */
public class PrimeGenerator implements Runnable
{
    @GuardedBy("this")
    private final List<BigInteger> primes = new ArrayList<>();
    private volatile boolean cancelled;

    @Override
    public void run()
    {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel()
    {
        this.cancelled = true;
    }

    public synchronized List<BigInteger> get()
    {
        return new ArrayList<>(primes);
    }
}
