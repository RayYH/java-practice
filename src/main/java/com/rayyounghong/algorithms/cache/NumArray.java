package com.rayyounghong.algorithms.cache;

/**
 * 给定一个整数数组 nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 *
 * @author ray
 */
public class NumArray {
    /** 缓存 nums[0:*] 的元素和 */
    public int[] tables;

    /**
     * 在数组初始化的时候，缓存从 0 到 i 索引范围的所有元素的合。
     *
     * @param nums
     *            给定的数组
     */
    public NumArray(int[] nums) {
        tables = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            tables[i + 1] = tables[i] + nums[i];
        }
    }

    /**
     * 返回构造函数中传递的数组 nums 中 nums[i:j+1] 的和。
     *
     * @param i
     *            左边界
     * @param j
     *            右边界
     * @return 指定子数组中所有元素的和
     */
    public int sumRange(int i, int j) {
        return tables[j + 1] - tables[i];
    }
}
