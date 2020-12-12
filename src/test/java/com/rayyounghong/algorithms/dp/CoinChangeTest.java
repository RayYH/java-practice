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
        assertEquals(3, CoinChange.minimumCoins(coins, 11));
        assertEquals(2, CoinChange.minimumCoins(coins, 10));
        assertEquals(6, CoinChange.minimumCoins(coins, 30));
        assertEquals(-1, CoinChange.minimumCoins(coins, -1));
        assertEquals(3, CoinChange.minimumCoinsTabulation(coins, 11));
        assertEquals(2, CoinChange.minimumCoinsTabulation(coins, 10));
        assertEquals(6, CoinChange.minimumCoinsTabulation(coins, 30));
        assertEquals(-1, CoinChange.minimumCoinsTabulation(coins, -1));
    }
}
