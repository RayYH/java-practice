package com.rayyounghong.algorithms.dp;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择『某一天』买入这只股票，并选择在『未来的某一个不同的日子』卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @author ray
 * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/">买卖股票的最佳时机</a>
 */
public class BestTimeToBuyAndSellStock {
    /**
     * 采用自底向上的解法，大多数时候自底向上比自顶向下要直观明了。
     *
     * @param prices
     *            给定的数组
     * @return 最大利润
     */
    public static int tabulation(int[] prices) {
        // STEP 1: 计算迭代公式
        /*
         * 假设 F(i) 为第 i 天卖出股票时所能获取的最大利润，那么我们可以有如下的推导
         *
         * F(0) = 0
         * F(i) = max{prices[i] - prices[i-1], prices[i] - prices[i-2], ...}
         *      = prices[i] - min{prices[i-1], prices[i-2], ...}
         *      = max{prices[i] - prices[i-1], prices[i] - min{prices[i-2], prices[i-3], ...}}
         *
         * 另一方面，我们有：F(i-1) = prices[i-1] - min{prices[i-2], prices[i-3], ...}
         * --> min{prices[i-2], prices[i-3], ...} = prices[i-1] - F(i-1)
         *
         * 将该式替换到 F(i) 的解析式中去，我们有
         *
         * F(i) = max{prices[i] - prices[i-1], prices[i] - (prices[i-1] - F(i-1)}
         *
         * 令 sub = prices[i] - prices[i-1]，则 F(i) = max{sub, sub+F(i-1)}
         */

        // STEP 2: 验证传入的参数是否合法
        if (prices.length == 0) {
            return 0;
        }

        // STEP 3: 初始化 tables
        int[] tables = new int[prices.length];

        // STEP 4: 处理基础 case
        tables[0] = 0;

        // STEP 5: 通过公式更新 tables，并同步更新最优解
        int res = tables[0];
        for (int i = 1; i < prices.length; i++) {
            int sub = prices[i] - prices[i - 1];
            tables[i] = Math.max(sub, sub + tables[i - 1]);
            res = Math.max(tables[i], res);
        }

        // STEP 6: 返回最优解
        return res;
    }
}
