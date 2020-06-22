package com.rayyounghong.algorithms;

import java.util.List;

/**
 * GCD (Greatest Common Divisor) or HCF (Highest Common Factor) of two numbers is the largest number that divides both
 * of them.
 *
 * @author ray
 * @date 2020/6/22
 */
public class Gcd {

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

    public static int solutionEuclideanAlgorithmViaModuloOperator(int a, int b) {
        if (b == 0) {
            return a;
        }

        return solutionEuclideanAlgorithmViaModuloOperator(b, a % b);
    }
}
