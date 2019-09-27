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

package tutorial.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BinomialDistribution {

    /**
     * Out of numTrials trials where numCorrect have been chosen correct, what is the chance that the result was random
     * when those trials are 50/50 chances each?
     *
     * @see http://phintsan.kapsi.fi/abx.html
     * @see http://mathworld.wolfram.com/BinomialDistribution.html
     */
    public static double computePValue(int numCorrect, int numTrials) {
        return (computePValue(numCorrect, numTrials, 0.5d));
    }

    /**
     * Out of numTrials trials each of which have chance chance of being guessed, where numCorrect have been chosen
     * correct, what is the chance that the result was random?
     *
     * @see http://phintsan.kapsi.fi/abx.html
     * @see http://mathworld.wolfram.com/BinomialDistribution.html
     */
    public static double computePValue(int numCorrect, int numTrials, double chance) {
        double total = 0d;

        // want chance that one could guess numCorrect to numTrials times correctly (since e.g. guessing numCorrect+1
        // times correctly implies guessing numCorrect times correctly)
        for (int i = numCorrect; i <= numTrials; i++) {
            total += binomialDist(i, numTrials, chance);
        }

        return (total);
    }

    /**
     * Return the peptide score.
     *
     * @param aTrails      number of trails.
     * @param aProbability match probability, if peak depth is 6, window size is 100, then probability is 0.06 for
     *                     ascore, phosphors is different.
     * @param aMatchCount  match peak count
     * @return peptide random match score.
     * @since 1.00
     */
    public static double getScore(int aTrails, double aProbability, int aMatchCount) {

        double pro = 0.0;
        for (int i = aMatchCount; i <= aTrails; i++) {
            pro += binomialDist(i, aTrails, aProbability);
        }
        return -10 * Math.log10(pro);
    }

    /**
     * Compute the binomial distribution function for numCorrect correct choices out of numTrials trials with
     * probability of probValue.
     *
     * @see http://mathworld.wolfram.com/BinomialDistribution.html
     */
    public static double binomialDist(int numCorrect, int numTrials, double probValue) {
        BigInteger ntF = factorial(numTrials);
        BigInteger denom = factorial(numCorrect).multiply(factorial(numTrials - numCorrect));

        BigDecimal ntFBD = new BigDecimal(ntF);
        BigDecimal denomBD = new BigDecimal(denom);
        BigDecimal quotient = ntFBD.divide(denomBD, 40, RoundingMode.HALF_UP);

        BigDecimal restBD = BigDecimal.valueOf(Math.pow(probValue, numCorrect) * Math.pow((1d - probValue), numTrials
                - numCorrect));
        return (quotient.multiply(restBD).doubleValue());
    }

    /**
     * Compute factorial of n
     */
    public static BigInteger factorial(int n) {
        BigInteger res = BigInteger.ONE;

        for (int i = n; i > 1; i--) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return (res);
    }

    public static void main(String[] args) {

        System.out.println(getScore(26, 0.04, 18));

        System.out.println("The pValue of 10 guesses out of 13 for a coin flip is: " + computePValue(10, 13));
    }
}