package com.rayyounghong.algorithms.dp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class CoinChangeTest {
    @Test
    void testCoinChange() {
        int[] coins = new int[] {1, 2, 5};
        assertEquals(3, CoinChange.coinChange(coins, 11));
        assertEquals(2, CoinChange.coinChange(coins, 10));
        assertEquals(6, CoinChange.coinChange(coins, 30));
        assertEquals(-1, CoinChange.coinChange(coins, -1));
        assertEquals(3, CoinChange.coinChangeTabulation(coins, 11));
        assertEquals(2, CoinChange.coinChangeTabulation(coins, 10));
        assertEquals(6, CoinChange.coinChangeTabulation(coins, 30));
        assertEquals(-1, CoinChange.coinChangeTabulation(coins, -1));
    }
}
