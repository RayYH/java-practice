package com.rayyounghong.algorithms.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ray
 */
public class CoinChange {

    static Map<Integer, Integer> dp = new HashMap<>();

    /**
     * Memoization
     *
     * @param coins
     *            coins
     * @param amount
     *            amount
     * @return the minimum coins
     */
    public static int coinChange(int[] coins, int amount) {
        if (dp.containsKey(amount)) {
            return dp.get(amount);
        }

        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int res = Integer.MAX_VALUE;

        for (int coin : coins) {
            int subSolution = coinChange(coins, amount - coin);
            // no solution
            if (subSolution == -1) {
                continue;
            }
            res = Math.min(res, 1 + subSolution);
        }

        dp.put(amount, res != Integer.MAX_VALUE ? res : -1);
        return dp.get(amount);
    }

    /**
     * Tabulation
     *
     * @param coins
     *            coins
     * @param amount
     *            amount
     * @return the minimum coins
     */
    public static int coinChangeTabulation(int[] coins, int amount) {
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
