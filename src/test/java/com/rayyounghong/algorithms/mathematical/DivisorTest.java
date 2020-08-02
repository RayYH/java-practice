package com.rayyounghong.algorithms.mathematical;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class DivisorTest {

    @Test
    void divisor() {
        assertEquals("[1, 2, 50, 100, 4, 20, 5, 25, 10]", Divisor.disorderedDivisors(100).toString());
        assertEquals("[1, 2, 3, 6]", Divisor.disorderedDivisors(6).toString());
        assertEquals("[1, 2, 4, 5, 10, 20, 25, 50, 100]", Divisor.orderedDivisors(100).toString());
        assertEquals("[1, 2, 3, 6]", Divisor.orderedDivisors(6).toString());
    }
}
