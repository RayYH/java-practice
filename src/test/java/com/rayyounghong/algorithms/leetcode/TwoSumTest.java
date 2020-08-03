package com.rayyounghong.algorithms.leetcode;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class TwoSumTest {
    @Test
    void testSolution() throws IllegalAccessException {
        TwoSum twoSum = new TwoSum();
        int[] arr = {2, 7, 11, 15};
        assertEquals(Arrays.toString(twoSum.twoSum(arr, 9)), "[0, 1]");
        assertEquals(Arrays.toString(twoSum.twoSum(arr, 18)), "[1, 2]");
    }
}
