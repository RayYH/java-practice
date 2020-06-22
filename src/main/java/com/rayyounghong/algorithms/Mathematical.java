package com.rayyounghong.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ray
 * @date 2020/6/22
 */
public class Mathematical {

    /**
     * A function to print all prime factors of a given number n
     *
     * <a href="https://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/">Efficient program to print all
     * prime factors of a given number</a>
     *
     * @param n
     *            given number
     * @return all prime factors
     */
    public static List<Integer> getAllPrimeFactors(int n) {
        List<Integer> list = new ArrayList<>();

        int minusPrimeNumber = 2;

        // Print the number of 2s that divide n
        while (n % minusPrimeNumber == 0) {
            list.add(minusPrimeNumber);
            n /= minusPrimeNumber;
        }

        // n must be odd at this point. So we can skip one element (Note i = i +2)
        for (int i = 3; i < Math.sqrt(n); i += minusPrimeNumber) {
            // While i divides n, divide n
            while (n % i == 0) {
                list.add(i);
                n /= i;
            }
        }

        if (n > minusPrimeNumber) {
            list.add(n);
        }

        return list;
    }

    /**
     * Given a number n, print all primes smaller than or equal to n. It is also given that n is a small number.
     *
     * <a href="https://www.geeksforgeeks.org/sieve-of-eratosthenes/">Sieve of Eratosthenes</a>
     *
     * @param n
     *            given number
     * @return all primers smaller than or equal to n
     */
    public static List<Integer> sieveOfEratosthenes(int n) {
        List<Integer> list = new ArrayList<>();

        // Create a boolean array "prime[0..n]" and initialize all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean[] prime = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p]) {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                list.add(i);
            }
        }

        return list;
    }

    /**
     * Given a number n, print least prime factors of all numbers from 1 to n. We need to return 1 for 1.
     *
     * @param n
     *            given number
     * @return a map
     */
    public static Map<Integer, Integer> leastPrimeFactor(int n) {
        Map<Integer, Integer> map = new HashMap<>(n);

        int two = 2;

        // Create a vector to store least primes. Initialize all entries as 0.
        int[] leastPrime = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            leastPrime[i] = 0;
        }

        // We need to print 1 for 1.
        leastPrime[1] = 1;

        for (int i = 2; i * i <= n; i++) {
            // leastPrime[i] == 0 means it i is prime
            if (leastPrime[i] == 0) {
                // marking the prime number as its own lpf
                leastPrime[i] = i;

                // mark it as a divisor for all its multiples if not already marked
                for (int j = two * i; j <= n; j += i) {
                    if (leastPrime[j] == 0) {
                        leastPrime[j] = i;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (leastPrime[i] == 0) {
                map.put(i, i);
            } else {
                map.put(i, leastPrime[i]);
            }
        }

        return map;
    }
}
