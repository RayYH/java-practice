package com.rayyounghong.algorithms.dp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class FibonacciTest {
    @Test
    void testFibonacci() {
        int[] cases = new int[] {0, 1, 1, 2, 3, 5, 8};
        Fibonacci f = new Fibonacci();
        for (int i = 0; i < cases.length; i++) {
            assertEquals(cases[i], f.memoization(i));
            assertEquals(cases[i], f.tabulation(i));
        }
    }
}
