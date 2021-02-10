package com.rayyounghong.algorithms.dp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class BestTimeToBuyAndSellStockTest {
    @Test
    void testDpSolution() {
        assertEquals(5, BestTimeToBuyAndSellStock.tabulation(new int[] {7, 1, 5, 3, 6, 4}));
        assertEquals(0, BestTimeToBuyAndSellStock.tabulation(new int[] {7, 6, 4, 3, 1}));
    }
}
