package com.rayyounghong.algorithms.dp;

public class ClimbingStairs {
    public static int tabulation(int n) {
        // formula, S = {1, 2}, F(n) = F(n-S1) + F(n-S2)

        // params validation
        if (n <= 0) {
            return 0;
        }

        // init tables
        int[] tables = new int[n + 1];
        int[] steps = new int[] {1, 2};

        // base case
        tables[0] = 1;

        // update tables
        for (int i = 1; i <= n; i++) {
            for (int step : steps) {
                if (i - step < 0) {
                    continue;
                }
                tables[i] += tables[i - step];
            }
        }

        // return solution stored in tables
        return tables[n];
    }
}
