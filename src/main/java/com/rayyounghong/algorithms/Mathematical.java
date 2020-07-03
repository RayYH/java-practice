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
     * 分解正整数，例如 12 = 2*2*3.
     *
     * 算法的逻辑很简单，我们先用 2 去除，除完之后，我们用 [3...sqrt(n)] 的每一个数去除，注意 i+=2。
     *
     * 另外还有一点需要注意的就是，如果在上述操作之后 n > 2，则需要把它自身加入，因为他本身可能只有它一个因子。
     *
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
     * 埃拉托色尼筛选法，找出小于或等于 n 的所有质数，核心思想就是逐步筛选掉质数的倍数：
     *
     * 1) 删除 2 及 2 的所有倍数 2) 删除 3 及 3 的所有倍数 3) 删除 5 及 5 的所有倍数 (跳过 4 是因为 4 是 2 的倍数，已经被标记为合数)
     *
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
        // 先假设所有的数都是质数
        boolean[] prime = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }

        // 为什么要 p^2 <= n ? 仔细看内部循环，内部循环是从 p*p 开始，如果 p*p > n 则超出了我们的考虑范围
        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            // 如果为 true 则代表是质数，需要进一步判断
            // p 自身一定是质数，因此只需从 p*p 开始
            if (prime[p]) {
                // Update all multiples of p
                // 所有为 p 的倍数
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }

        // 从 2 开始是因为当前数学界认为 1 既不是质数，也不是合数
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                list.add(i);
            }
        }

        return list;
    }

    /**
     * 最小质因数，即找出一系列数 [1...n] 中每个数的最小质因数，作为一个例外情况，针对 1 我们返回 1，虽然 1 不是质数。
     *
     * 我们也可以通过这个找出 <= n 的所有质数(最小质因数=自身) 即为质数。
     *
     * 这个算法和上面提到的 Eratosthenes 筛选法的核心思想是一致的。
     *
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
                for (int j = i * i; j <= n; j += i) {
                    if (leastPrime[j] == 0) {
                        leastPrime[j] = i;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (leastPrime[i] == 0) {
                // 自身即为最小质因数
                map.put(i, i);
            } else {
                map.put(i, leastPrime[i]);
            }
        }

        return map;
    }
}
