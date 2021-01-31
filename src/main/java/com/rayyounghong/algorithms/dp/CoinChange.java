package com.rayyounghong.algorithms.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Coin Change Problem.
 *
 * I. You are given coins of different denominations and a total amount of money amount. Write a function to compute the
 * fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1. You may assume that you have an infinite number of each kind of coin.
 *
 * II. You are given coins of different denominations and a total amount of money. Write a function to compute the
 * number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 *
 * @author ray
 * @see <a href="https://leetcode.com/problems/coin-change/">https://leetcode.com/problems/coin-change/</a>
 * @see <a href="https://leetcode.com/problems/coin-change-2/">https://leetcode.com/problems/coin-change-2/</a>
 */
public class CoinChange {

    /**
     * Memoization: <code>F(S)=F(S−C)+1</code>.
     *
     * @param coins
     *            coins
     * @param amount
     *            amount
     * @return the minimum number of coins
     */
    public static int minimumCoinsMemoization(int[] coins, int amount) {
        Map<Integer, Integer> memo = new HashMap<>(amount + 1);
        return minimumCoinsMemo(coins, amount, memo);
    }

    public static int minimumCoinsMemo(int[] coins, int amount, Map<Integer, Integer> memo) {
        // check memo
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        // base case and param validation
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        // recursive strategy
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subSolution = minimumCoinsMemo(coins, amount - coin, memo);
            if (subSolution == -1) {
                continue;
            }
            res = Math.min(res, subSolution + 1);
        }

        // update memo (no solution when initial value not changed) and return
        if (res == Integer.MAX_VALUE) {
            memo.put(amount, -1);
        } else {
            memo.put(amount, res);
        }

        return memo.get(amount);
    }

    /**
     * Tabulation.
     *
     * @param coins
     *            coins
     * @param amount
     *            amount
     * @return the minimum number of coins
     */
    public static int minimumCoinsTabulation(int[] coins, int amount) {
        // param validation
        if (amount < 0) {
            return -1;
        }

        // int tables
        int[] tables = new int[amount + 1];
        Arrays.fill(tables, amount + 1);

        // base case
        tables[0] = 0;

        // update tables via formula
        for (int i = 0; i < tables.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                tables[i] = Math.min(tables[i], 1 + tables[i - coin]);
            }
        }

        // return solution stored inside tables (no solution when initial value has not been modified)
        return (tables[amount] == amount + 1) ? -1 : tables[amount];
    }
}
