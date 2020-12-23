package com.rayyounghong.algorithms.mathematical;

/**
 * Review Date: 2020/12/23.
 *
 * GCD (Greatest Common Divisor) or HCF (Highest Common Factor) of two numbers is the largest number that divides both
 * of them.
 *
 * @author ray
 */
public class Gcd {
    /**
     * Euclidean algorithm (suggested): {@code gcd(a % b) = gcd(a, b)}.
     *
     * @param a
     *            first number
     * @param b
     *            second number
     * @return the gcd
     */
    public static int solutionEuclideanAlgorithm(int a, int b) {
        if (a < 0 || b < 0) {
            throw new ArithmeticException();
        }

        if (a == 0 || b == 0) {
            return Math.abs(a - b);
        }

        return solutionEuclideanAlgorithm(b, a % b);
    }

    /**
     * Get greatest common divisor - iterate.
     *
     * @param a
     *            the first number
     * @param b
     *            the second number
     * @return gcd
     */
    public static int gcd(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException();
        }

        if (a == 0 || b == 0) {
            return Math.abs(a - b);
        }

        while (a % b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        return b;
    }

    /**
     * Get greatest common divisor of a set of numbers.
     *
     * @param numbers
     *            an array contains numbers
     * @return gcd
     */
    public static int gcd(int[] numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = gcd(result, numbers[i]);
        }

        return result;
    }
}
