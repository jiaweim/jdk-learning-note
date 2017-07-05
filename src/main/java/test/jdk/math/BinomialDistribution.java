/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 JiaweiMao
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */

package test.jdk.math;

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