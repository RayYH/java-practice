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

    static Map<Integer, Integer> memo = new HashMap<>();

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
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        int res = Integer.MAX_VALUE;

        for (int coin : coins) {
            int subSolution = minimumCoinsMemoization(coins, amount - coin);

            // no solution
            if (subSolution == -1) {
                continue;
            }

            res = Math.min(res, 1 + subSolution);
        }

        memo.put(amount, res != Integer.MAX_VALUE ? res : -1);
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
        if (amount < 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
