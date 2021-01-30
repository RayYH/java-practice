package com.rayyounghong.algorithms.dp;

/**
 * @see <a href="https://en.wikipedia.org/wiki/Fibonacci_number">Fibonacci number</a>
 *
 * @author ray
 */
public class Fibonacci {
    final int MAX = 100;
    final int NIL = -1;
    int[] memo = new int[MAX];

    Fibonacci() {
        for (int i = 0; i < MAX; i++) {
            memo[i] = NIL;
        }
    }

    /**
     * Memoization (Top Down).
     *
     * @param n
     *            given number
     * @return the fib
     */
    public int memoization(int n) {
        // look into the memo table first
        if (memo[n] == NIL) {
            if (n <= 1) {
                memo[n] = n;
            } else {
                memo[n] = memoization(n - 1) + memoization(n - 2);
            }
        }

        return memo[n];
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
