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

        // 已经初始化过了
        if (SPF[two] != 0) {
            return;
        }

        SPF[1] = 1;
        for (int i = 2; i < MAX_NUMBER; i++) {
            // marking smallest prime factor for every number to be itself.
            // 设所有 >=2 的数的最小质因数都为其自身
            SPF[i] = i;
        }

        // separately marking spf for every even number as 2
        for (int i = 4; i < MAX_NUMBER; i += two) {
            // 将所有 >= 2 的偶数的最小质因数设为 2
            SPF[i] = 2;
        }

        for (int i = 3; i * i < MAX_NUMBER; i++) {
            // checking if i is prime
            // SPF[i] == i 即表明 i 是质数
            if (SPF[i] == i) {
                // 然后把所有 i 的倍数的数的最小质因数标记为 i - 在因数这个主题上，我们一直在用这个套路
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
