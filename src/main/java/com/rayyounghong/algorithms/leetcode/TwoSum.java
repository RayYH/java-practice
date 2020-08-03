package com.rayyounghong.algorithms.leetcode;

import java.util.HashMap;

/**
 * <p>
 * Given an array of integers, return <strong>indices</strong> of the two numbers such that they add up to a specific
 * target.
 * </p>
 * You may assume that each input would have <strong><i>exactly</i></strong> one solution, and you may not use the
 * <i>same</i> element twice.
 *
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
