package com.rayyounghong.algorithms.mathematical;

import java.util.List;

/**
 * 最大公约数。
 *
 * GCD (Greatest Common Divisor) or HCF (Highest Common Factor) of two numbers is the largest number that divides both
 * of them.
 *
 * @author ray
 */
public class Gcd {

    /**
     * 第一种算法是很直观的算法，其思想就是找出 a 和 b 的所有因数，然后取共有的因数的最大值即可。
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
        List<Integer> aPrimeFactors = Divisor.solutionThree(a);
        List<Integer> bPrimeFactors = Divisor.solutionThree(b);

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
     * 算法2 ，即更相减损术：如果 {@code a>b}，则 {@code gcd(a-b, b) = gcd(a, b)}
     *
     * @param a
     *            first number
     * @param b
     *            second number
     * @return the gcd
     */
    public static int solutionEuclideanAlgorithm(int a, int b) {
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
            return solutionEuclideanAlgorithm(a - b, b);
        } else {
            return solutionEuclideanAlgorithm(a, b - a);
        }
    }

    /**
     * 欧几里得算法(推荐使用该算法): gcd(a % b) = gcd(a, b)。
     *
     * @param a
     *            first number
     * @param b
     *            second number
     * @return the gcd
     */
    public static int solutionEuclideanAlgorithmViaModuloOperator(int a, int b) {
        if (b == 0) {
            return a;
        }

        return solutionEuclideanAlgorithmViaModuloOperator(b, a % b);
    }
}
