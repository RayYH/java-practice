package com.rayyounghong.algorithms.leetcode;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/two-sum/">Two Sum</a>
 * @author ray
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) throws IllegalArgumentException {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
