package com.rayyounghong.algorithms.mathematical;

/**
 * Binomial coefficient.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Binomial_coefficient">Binomial coefficient</a>
 * @author ray
 */
public class BinomialCoefficient {
    public static long binomialCoefficient(long n, long k) {
        if (k < 0 || n < k) {
            throw new IllegalArgumentException("n & k should match n >= k >= 0");
        }

        return PositiveInteger.factorial(n) / (PositiveInteger.factorial(k) * PositiveInteger.factorial(n - k));
    }
}
