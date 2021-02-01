package com.rayyounghong.ds.arrays;

public class RangeSumQueryImmutable {
    public int[] tables;

    public RangeSumQueryImmutable(int[] nums) {
        tables = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            tables[i + 1] = tables[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return tables[j + 1] - tables[i];
    }
}
