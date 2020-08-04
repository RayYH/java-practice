package com.rayyounghong.algorithms.mathematical;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author ray
 */
public class PositiveIntegerTest {
    @Test
    void testFactorial() {
        assertThrows(ArithmeticException.class, () -> {
            PositiveInteger.factorial(-1);
        });
        assertEquals(120, PositiveInteger.factorial(5));
        assertEquals(720, PositiveInteger.factorial(6));
        assertEquals(5040, PositiveInteger.factorial(7));
        assertEquals(120, PositiveInteger.factorial(5, 1));
        assertEquals(720, PositiveInteger.factorial(6, 1));
        assertEquals(5040, PositiveInteger.factorial(7, 1));
    }

    @Test
    void testCatalanNumbers() {
        List<Long> l = new ArrayList<>();
        for (long i = 1; i < 10; i++) {
            l.add(PositiveInteger.catalanNumber(i));
        }
        assertEquals("[1, 2, 5, 14, 42, 132, 429, 1430, 4862]", l.toString());
    }
}
