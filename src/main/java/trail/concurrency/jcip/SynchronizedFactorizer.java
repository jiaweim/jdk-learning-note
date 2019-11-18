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

import trail.concurrency.jcip.annotations.GuardedBy;
import trail.concurrency.jcip.annotations.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Servlet that caches last result, but with unnacceptably poor concurrency
 *
 * @author JiaweiMao 2017-05-05
 * @since 1.0-SNAPSHOT
 */
@ThreadSafe
public class SynchronizedFactorizer extends GenericServlet implements Servlet {

    @GuardedBy("this") private BigInteger lastNumber;
    @GuardedBy("this") private BigInteger[] lastFactors;

    @Override
    public synchronized void service(ServletRequest servletRequest, ServletResponse servletResponse) throws
            ServletException, IOException {
        BigInteger i = extractFromRequest(servletRequest);
        if (i.equals(lastNumber))
            encodeIntoResponse(servletResponse, lastFactors);
        else {
            BigInteger[] factors = factor(i);
            lastNumber = i;
            lastFactors = factors;
            encodeIntoResponse(servletResponse, factors);
        }
    }

    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }
}
