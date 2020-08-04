package com.rayyounghong.algorithms.mathematical;

/**
 * Some functions for getting n-th value.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Factorial">Factorial</a>
 * @see <a href="https://en.wikipedia.org/wiki/Catalan_number">Catalan number</a>
 * @author ray
 */
public class PositiveInteger {

    /**
     * Get the factorial of given number n.
     *
     * @param n
     *            given number n.
     * @return return the factorial of n.
     */
    public static long factorial(long n) {
        if (n < 0) {
            throw new ArithmeticException("given value cannot be negative");
        }

        // Binomial coefficient use this functions will pass an argument with value 0
        // we should return 1 since 1C0 should produce 1
        if (n == 1 || n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    /**
     * Get the factorial of given number n - Tail call optimization.
     *
     * @param n
     *            given number n.
     * @param total
     *            current total
     * @return return the factorial of n.
     */
    public static long factorial(long n, long total) {
        if (n < 0) {
            throw new ArithmeticException("given value cannot be negative");
        }

        // Binomial coefficient use this functions will pass an argument with value 0
        // we should return 1 since 1C0 should produce 1
        if (n == 1) {
            return total;
        }

        return factorial(n - 1, n * total);
    }

    /**
     * Find {@code n}-th catalan number.
     *
     * @param n
     *            given number
     * @return the {@code n}-th catalan number
     */
    public static long catalanNumber(long n) {
        int res = 0;

        if (n <= 1) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            res += catalanNumber(i) * catalanNumber((n - 1) - i);
        }

        return res;
    }
}
