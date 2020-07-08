package com.rayyounghong.algorithms.mathematical;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class PrimeFactorizationTest {

    @Test
    void testPrimeFactorization() {
        assertEquals("[2, 3, 3]", PrimeFactorization.getFactorization(18).toString());
        assertEquals("[2, 3, 13, 157]", PrimeFactorization.getFactorization(12246).toString());
    }
}
