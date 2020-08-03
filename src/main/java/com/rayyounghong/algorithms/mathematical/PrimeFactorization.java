package com.rayyounghong.algorithms.mathematical;

import java.util.Vector;

/**
 * @author ray
 */
public class PrimeFactorization {

    private static final int MAX_NUMBER = 100000;

    /**
     * stores smallest prime factor for every number.
     */
    private static final int[] SPF = new int[MAX_NUMBER];

    /**
     * Calculating SPF (Smallest Prime Factor) for every number till MAX_NUMBER.
     *
     * Time Complexity : O(nloglogn).
     */
    private static void sieve() {
        int two = 2;

        if (SPF[two] != 0) {
            return;
        }

        SPF[1] = 1;
        for (int i = 2; i < MAX_NUMBER; i++) {
            // marking smallest prime factor for every number to be itself.
            SPF[i] = i;
        }

        // separately marking spf for every even number as 2
        for (int i = 4; i < MAX_NUMBER; i += two) {
            SPF[i] = 2;
        }

        for (int i = 3; i * i < MAX_NUMBER; i++) {
            // checking if i is prime
            if (SPF[i] == i) {
                // marking SPF for all numbers divisible by i
                for (int j = i * i; j < MAX_NUMBER; j += i) {
                    // marking spf[j] if it is not previously marked
                    if (SPF[j] == j) {
                        SPF[j] = i;
                    }
                }
            }
        }
    }

    /**
     * A O(log n) function returning prime factorization, by dividing by smallest prime factor at every step
     *
     * @param x
     *            given number
     * @return vector
     */
    public static Vector<Integer> getFactorization(int x) {
        PrimeFactorization.sieve();
        Vector<Integer> ret = new Vector<>();
        while (x != 1) {
            ret.add(SPF[x]);
            x = x / SPF[x];
        }
        return ret;
    }
}
