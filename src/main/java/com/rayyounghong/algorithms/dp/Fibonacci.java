package com.rayyounghong.algorithms.dp;

/**
 * Fibonacci numbers.
 *
 * <code>
 * F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2).
 * </code>
 *
 * @author ray
 */
public class Fibonacci {
    final int MAX = 100;
    final int NIL = -1;
    int[] lookup = new int[MAX];

    Fibonacci() {
        for (int i = 0; i < MAX; i++) {
            lookup[i] = NIL;
        }
    }

    /**
     * Recursive solution.
     *
     * @param n
     *            given number
     * @return the fib
     */
    public int recursion(int n) {
        if (n <= 1) {
            return n;
        }

        return recursion(n - 1) + recursion(n - 2);
    }

    /**
     * Memoization (Top Down).
     *
     * @param n
     *            given number
     * @return the fib
     */
    public int memoization(int n) {
        // look into the lookup table first
        if (lookup[n] == NIL) {
            if (n <= 1) {
                lookup[n] = n;
            } else {
                lookup[n] = memoization(n - 1) + memoization(n - 2);
            }
        }

        return lookup[n];
    }

    /**
     * Tabulation (Bottom Up).
     *
     * @param n
     *            given number
     * @return the fib
     */
    public int tabulation(int n) {
        int[] table = new int[n + 1];

        table[0] = 0;

        if (n != 0) {
            table[1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }

        return table[n];
    }
}
