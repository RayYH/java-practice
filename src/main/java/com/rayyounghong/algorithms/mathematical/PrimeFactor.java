package com.rayyounghong.algorithms.mathematical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a number {@code n}, write an efficient function to print all prime factors of {@code n}. For example, if the
 * input number is {@code 12}, then output should be {@code 2 2 3}, since {@code 12 = 2 * 2 * 3} And if the input number
 * is {@code 315}, then output should be {@code 3 3 5 7}.
 *
 * <a href="https://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/">Efficient program to print all
 * prime factors of a given number</a>
 *
 * @author ray
 */
public class PrimeFactor {

    /**
     * Following are the steps to find all prime factors.
     *
     * <ol>
     * <li>While {@code n} is divisible by {@code 2}, add {@code 2} to the list and divide {@code n} by {@code 2}.</li>
     * <li>After step 1, {@code n} must be odd. Now start a loop from {@code i = 3} to square root of {@code n}. While
     * {@code i} divides {@code n}, print {@code i} and divide {@code n} by {@code i}. After {@code i} fails to divide
     * {@code n}, increment {@code i} by {@code 2} and continue .</li>
     * <li>If {@code n} is a prime number and is greater than {@code 2}, then {@code n} will not become {@code 1} by
     * above two steps. So add {@code n} if it is greater than {@code 2}.</li>
     * </ol>
     *
     * @param n
     *            given number
     * @return all prime factors
     */
    public static List<Integer> getAllPrimeFactors(int n) {
        List<Integer> list = new ArrayList<>();

        int minusPrimeNumber = 2;

        // Get the number of 2s that divide n
        while (n % minusPrimeNumber == 0) {
            list.add(minusPrimeNumber);
            n /= minusPrimeNumber;
        }

        // n must be odd at this point. So we can skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i += minusPrimeNumber) {
            // While i divides n, add i and divide n
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
     * In mathematics, the sieve of Eratosthenes is an ancient algorithm for finding all prime numbers up to any given
     * limit.
     *
     * To find all the prime numbers less than or equal to a given integer n by Eratosthenes' method:
     * <ol>
     * <li>Create a list of consecutive integers from {@code 2} through {@code n}: {@code 2, 3, 4, ..., n}.</li>
     * <li>Initially, let {@code p} equal {@code 2}, the smallest prime number.</li>
     * <li>Enumerate the multiples of {@code p} by counting in increments of {@code p} from {@code 2p} to {@code n}, and
     * mark them in the list (these will be {@code 2p}, {@code 3p}, {@code 4p}, ...; the {@code p} itself should not be
     * marked) .</li>
     * <li>Find the smallest number in the list greater than {@code p} that is not marked. If there was no such number,
     * stop. Otherwise, let p now equal this new number (which is the next prime), and repeat from step 3.</li>
     * <li>When the algorithm terminates, the numbers remaining not marked in the list are all the primes below
     * {@code n}.</li>
     * </ol>
     *
     * <a href="https://www.geeksforgeeks.org/sieve-of-eratosthenes/">Sieve of Eratosthenes</a>
     * <a href="https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes">Sieve of Eratosthenes</a>
     *
     * @param n
     *            given number
     * @return all primers smaller than or equal to n
     */
    public static List<Integer> sieveOfEratosthenes(int n) {
        List<Integer> list = new ArrayList<>();

        // Create a boolean array "prime[0..n]" and initialize all entries it as true (which means marked prime
        // factors) A value in prime[i] will finally be false if i is Not a prime, else true.
        boolean[] prime = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime, then the multiples of p should be marked false
            if (prime[p]) {
                // Update all multiples of p greater than or equal to the square of it numbers which are multiple of
                // p and are less than p^2 are already been marked.
                // [p^2, p^2+p, p^2+2p, ...]
                // starting from p^2, as all the smaller multiples of p will have already been marked at that point
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }

        // Every positive integer is composite, prime, or the unit 1, so 1 is neither a primer nor a composite.
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
     * <p>
     * {2, 3, 2, 5, 2, 7, 2, 3, 2, 11, 2, 13, 2, 3, 2, 17, 2, 19, 2, 3, 2, 23, 2, 5, 2, 3, 2, 29, 2, 31, 2, 3, ...}
     * </p>
     *
     * <a href="https://oeis.org/wiki/Least_prime_factor_of_n">Least prime factor of n</a>
     *
     * @param n
     *            given number
     * @return a map
     */
    public static Map<Integer, Integer> leastPrimeFactor(int n) {
        Map<Integer, Integer> map = new HashMap<>(n);

        // Create an array to store least primes.
        // Initialize all entries as 0.
        int[] leastPrime = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            leastPrime[i] = 0;
        }

        // We need to return 1 for 1.
        leastPrime[1] = 1;

        for (int i = 2; i * i <= n; i++) {
            // leastPrime[i] == 0 means i is prime
            if (leastPrime[i] == 0) {
                // marking the prime number as its own lpf
                leastPrime[i] = i;
                // mark it as a divisor for all its multiples if not already marked
                for (int j = i * i; j <= n; j += i) {
                    if (leastPrime[j] == 0) {
                        leastPrime[j] = i;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (leastPrime[i] == 0) {
                // the prime number as its own lpf
                map.put(i, i);
            } else {
                map.put(i, leastPrime[i]);
            }
        }

        return map;
    }
}
