package com.rayyounghong.algorithms.dp;

public class MaximumSubArray {
    public static int tabulation(int[] nums) {
        // formula: F(i) = max{F(i-1) + nums[i], num[i]}

        // param validation
        if (nums.length <= 0) {
            return 0;
        }

        // init tables
        int[] tables = new int[nums.length];

        // base case
        tables[0] = nums[0];

        // update tables
        int res = tables[0];
        for (int i = 1; i < nums.length; i++) {
            tables[i] = Math.max(tables[i - 1] + nums[i], nums[i]);
            res = Math.max(tables[i], res);
        }

        // return optimal solution stored in tables
        return res;
    }
}
