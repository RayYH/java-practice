package com.rayyounghong.algorithms.dp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSubArrayTest {
    @Test
    void tabulationTest() {
        assertEquals(MaximumSubArray.tabulation(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}), 6);
        assertEquals(MaximumSubArray.tabulation(new int[] {1}), 1);
        assertEquals(MaximumSubArray.tabulation(new int[] {0}), 0);
        assertEquals(MaximumSubArray.tabulation(new int[] {-1}), -1);
        assertEquals(MaximumSubArray.tabulation(new int[] {-10000}), -10000);
    }
}
