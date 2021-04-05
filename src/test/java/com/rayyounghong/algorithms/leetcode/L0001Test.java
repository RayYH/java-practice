package com.rayyounghong.algorithms.leetcode;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class L0001Test {
    @Test
    void testSolution() throws IllegalAccessException {
        L0001 l0001 = new L0001();
        int[] arr = {2, 7, 11, 15};
        assertEquals(Arrays.toString(l0001.twoSum(arr, 9)), "[0, 1]");
        assertEquals(Arrays.toString(l0001.twoSum(arr, 18)), "[1, 2]");
    }
}
