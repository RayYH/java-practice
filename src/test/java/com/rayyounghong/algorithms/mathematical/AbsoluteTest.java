package com.rayyounghong.algorithms.mathematical;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class AbsoluteTest {

    @Test
    void testAbsValue() {
        assertEquals(34, Absolute.absValue(-34));
        assertEquals(34, Absolute.absValue(34));
        assertEquals(0, Absolute.absValue(0));
    }

    @Test
    void testAbsMax() {
        assertEquals(-34, Absolute.absMax(new int[] {1, 2, 3, 27, -34}));
        assertEquals(34, Absolute.absMax(new int[] {1, 2, -3, -27, 34}));
    }

    @Test
    void testAbsMin() {
        assertEquals(-1, Absolute.absMin(new int[] {-1, 2, 3, 27, -34}));
        assertEquals(1, Absolute.absMin(new int[] {1, 2, -3, -27, 34}));
    }

}
