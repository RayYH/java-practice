package com.rayyounghong.algorithms.mathematical;

import com.rayyounghong.helper.DisableInspection;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Review Date: 2020/12/23.
 *
 * @author ray
 */
public class PositiveIntegerTest {

    @Test
    void testFactorial() {
        assertThrows(ArithmeticException.class, () -> PositiveInteger.factorial(-1));
        assertThrows(ArithmeticException.class, () -> PositiveInteger.factorial(-1, 1));
        assertThrows(ArithmeticException.class,
            () -> DisableInspection.doWhatEver(PositiveInteger.factorialViaIterativeLoops(-1)));
        assertEquals(120, PositiveInteger.factorial(5));
        assertEquals(720, PositiveInteger.factorial(6));
        assertEquals(5040, PositiveInteger.factorial(7));
        assertEquals(120, PositiveInteger.factorial(5, 1));
        assertEquals(720, PositiveInteger.factorial(6, 1));
        assertEquals(5040, PositiveInteger.factorial(7, 1));
        assertEquals(120, PositiveInteger.factorialViaIterativeLoops(5));
        assertEquals(720, PositiveInteger.factorialViaIterativeLoops(6));
        assertEquals(5040, PositiveInteger.factorialViaIterativeLoops(7));
    }

    @Test
    void testCatalanNumbers() {
        List<Long> l = new ArrayList<>();
        for (long i = 0; i < 10; i++) {
            l.add(PositiveInteger.catalanNumber(i));
        }
        assertEquals("[1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862]", l.toString());
        l.clear();
        for (long i = 0; i < 10; i++) {
            l.add(PositiveInteger.catalan(i));
        }
        assertEquals("[1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862]", l.toString());
    }

}
