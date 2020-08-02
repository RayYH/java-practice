package com.rayyounghong.algorithms.mathematical;

import java.util.List;

/**
 * GCD (Greatest Common Divisor) or HCF (Highest Common Factor) of two numbers is the largest number that divides both
 * of them.
 *
 * @author ray
 */
public class Gcd {

    /**
     * An intuitive solution: calculate all common divisors of a & b, then find the greatest common divisor.
     *
     * @param a
     *            first value
     * @param b
     *            second value
     * @return the gcd
     */
    public static int solutionTraverseAllDivisors(int a, int b) {
        if (a == 0) {
            return 0;
        }

        if (b == 0) {
            return 0;
        }

        if (a == b) {
            return a;
        }

        int i, j, gcd = 1;
        int compare;

        List<Integer> aPrimeFactors = Divisor.orderedDivisors(a);
        List<Integer> bPrimeFactors = Divisor.orderedDivisors(b);

        int aSize = aPrimeFactors.size();
        int bSize = bPrimeFactors.size();

        for (i = 0, j = 0; i < aSize && j < bSize;) {
            compare = aPrimeFactors.get(i).compareTo(bPrimeFactors.get(j));

            if (compare < 0) {
                i++;
            } else if (compare > 0) {
                j++;
            } else {
                gcd = aPrimeFactors.get(i);
                i++;
                j++;
            }
        }

        return gcd;
    }

    /**
     * Chinese remainder theorem if {@code a>b}, then {@code gcd(a-b, b) = gcd(a, b)}.
     *
     * @param a
     *            first number
     * @param b
     *            second number
     * @return the gcd
     */
    public static int solutionChineseRemainderTheorem(int a, int b) {
        // Everything divides 0
        if (a == 0) {
            return 0;
        }

        if (b == 0) {
            return 0;
        }

        // base case
        if (a == b) {
            return a;
        }

        if (a > b) {
            return solutionChineseRemainderTheorem(a - b, b);
        } else {
            return solutionChineseRemainderTheorem(a, b - a);
        }
    }

    /**
     * Euclidean algorithm (suggested), {@code gcd(a % b) = gcd(a, b)}.
     *
     * @param a
     *            first number
     * @param b
     *            second number
     * @return the gcd
     */
    public static int solutionEuclideanAlgorithm(int a, int b) {
        if (b == 0) {
            return a;
        }

        return solutionEuclideanAlgorithm(b, a % b);
    }
}
