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
        assertEquals(3, CoinChange.minimumCoinsMemoization(coins, 11));
        assertEquals(2, CoinChange.minimumCoinsMemoization(coins, 10));
        assertEquals(6, CoinChange.minimumCoinsMemoization(coins, 30));
        assertEquals(-1, CoinChange.minimumCoinsMemoization(coins, -1));
        assertEquals(3, CoinChange.minimumCoinsTabulation(coins, 11));
        assertEquals(2, CoinChange.minimumCoinsTabulation(coins, 10));
        assertEquals(6, CoinChange.minimumCoinsTabulation(coins, 30));
        assertEquals(-1, CoinChange.minimumCoinsTabulation(coins, -1));
        coins[0] = 7;
        coins[1] = 8;
        coins[2] = 9;
        assertEquals(-1, CoinChange.minimumCoinsMemoization(coins, 4));
    }

    @Test
    void testCoinChangeCombinations() {
        int[] coins = new int[] {1, 2, 5};
        assertEquals(4, CoinChange.totalCombinationsTabulation(coins, 5));
        assertEquals(0, CoinChange.totalCombinationsTabulation(new int[] {2}, 3));
        assertEquals(1, CoinChange.totalCombinationsTabulation(new int[] {10}, 10));
    }
}
