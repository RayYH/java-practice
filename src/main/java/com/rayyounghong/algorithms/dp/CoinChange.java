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

    public static int minimumCoinsMemoization(int[] coins, int amount) {
        Map<Integer, Integer> memo = new HashMap<>(amount + 1);
        return minimumCoinsMemo(coins, amount, memo);
    }

    public static int minimumCoinsMemo(int[] coins, int amount, Map<Integer, Integer> memo) {
        // 1. check memo
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        // 2. base case and param validation
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        // 3. recursive strategy using formula
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subSolution = minimumCoinsMemo(coins, amount - coin, memo);
            if (subSolution == -1) {
                continue;
            }
            res = Math.min(res, subSolution + 1);
        }

        // 4. update memo (no solution when initial value not changed) and return
        if (res == Integer.MAX_VALUE) {
            memo.put(amount, -1);
        } else {
            memo.put(amount, res);
        }

        return memo.get(amount);
    }

    public static int minimumCoinsTabulation(int[] coins, int amount) {
        // 1. param validation
        if (amount < 0) {
            return -1;
        }

        // 2. int tables
        int[] tables = new int[amount + 1];
        Arrays.fill(tables, amount + 1);

        // 3. base case
        tables[0] = 0;

        // 4. update tables using formula
        for (int i = 0; i < tables.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                tables[i] = Math.min(tables[i], 1 + tables[i - coin]);
            }
        }

        // 5. return solution stored inside tables (no solution when initial value has not been modified)
        return (tables[amount] == amount + 1) ? -1 : tables[amount];
    }

    public static int totalCombinationsMemoization(int[] coins, int amount) {
        Map<Integer, Integer> memo = new HashMap<>(amount + 1);
        return totalCombinationsMemo(coins, amount, memo);
    }

    public static int totalCombinationsMemo(int[] coins, int amount, Map<Integer, Integer> memo) {
        // 1. check memo
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        // 2. base case and param validation
        if (amount == 0) {
            return 1;
        }
        if (amount < 0) {
            return 0;
        }

        // 3. recursive strategy using formula
        int res = 0;
        for (int coin : coins) {
            int remain = amount - coin;
            if (remain == coin) {
                res += 1;
            }

            if (remain < coin) {
                continue;
            }

            res += totalCombinationsMemo(coins, amount - coin, memo);
        }

        // 4. update memo (no solution when initial value not changed) and return
        memo.put(amount, res);
        return res;
    }

    public static int totalCombinationsTabulation(int[] coins, int amount) {
        // 1. param validation
        if (amount < 0) {
            return 0;
        }

        // 2. int tables
        int[] tables = new int[amount + 1];
        Arrays.fill(tables, 0);

        // 3. base case
        tables[0] = 1;

        // 4. update tables using formula
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                tables[i] += tables[i - coin];
            }
        }

        // 5. return solution stored inside tables (no solution when initial value has not been modified)
        return tables[amount];
    }
}
