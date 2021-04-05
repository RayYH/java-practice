package com.rayyounghong.algorithms.leetcode;

import java.util.HashMap;

/**
 * @author ray
 */
public class L0001 {
    public int[] twoSum(int[] nums, int target) throws IllegalArgumentException {
        HashMap<Integer, Integer> cache = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (cache.containsKey(complement)) {
                return new int[] {cache.get(complement), i};
            }

            cache.put(nums[i], i);
        }

        throw new IllegalArgumentException("No solution");
    }
}
