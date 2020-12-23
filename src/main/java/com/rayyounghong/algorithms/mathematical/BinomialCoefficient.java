package com.rayyounghong.algorithms.mathematical;

/**
 * Review Date: 2020/12/23.
 *
 * In mathematics, the binomial coefficients are the positive integers that occur as coefficients in the binomial
 * theorem.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Binomial_coefficient">Binomial coefficient</a>
 * @author ray
 */
public class BinomialCoefficient {

    public static long binomialCoefficient(long n, long k) {
        if (k < 0 || n < k) {
            throw new IllegalArgumentException("n, k should match the rule: n >= k >= 0");
        }

        // (n, k) = n! / (k! * (n-k)!)
        return PositiveInteger.factorial(n) / (PositiveInteger.factorial(k) * PositiveInteger.factorial(n - k));
    }

}
