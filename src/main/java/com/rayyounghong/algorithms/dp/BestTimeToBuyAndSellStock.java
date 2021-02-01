package com.rayyounghong.algorithms.dp;

public class BestTimeToBuyAndSellStock {
    public static int tabulation(int[] prices) {
        // formula --> F(i) = (not consider 0 first)
        // max(prices[i] - prices[i-1], prices[i] - prices[i-2], ...)
        // = max(prices[i] - min(prices[i-1], prices[i-2], ...))
        // = max(prices[i] - prices[i-1], prices[i] - min(prices[i-2], prices[i-3], ...)
        // = max(prices[i] - prices[i-1], prices[i] - (prices[i-1] - F(i-1)))
        // = max(prices[i] - prices[i-1], prices[i] - prices[i-1] + F(i-1))
        //
        // F(i-1) =prices[i-1] - min(prices[i-2], prices[i-3], ...)

        // params validation
        if (prices.length == 0) {
            return 0;
        }

        // init tables
        int[] tables = new int[prices.length];

        // base case
        tables[0] = 0;

        // update tables using formula
        int res = tables[0];
        for (int i = 1; i < prices.length; i++) {
            int sub = prices[i] - prices[i - 1];
            tables[i] = Math.max(sub, sub + tables[i - 1]);
            res = Math.max(tables[i], res);
        }

        // return solution stored in tables
        return res;
    }
}
