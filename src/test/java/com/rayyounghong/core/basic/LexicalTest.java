package com.rayyounghong.core.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rayyounghong.helper.DisableInspection;
import org.junit.jupiter.api.Test;

/**
 * @author ray
 * @date 2020/5/9
 */
class LexicalTest {

    /*
     * The primitive types.
     *
     * byte(1)
     * short(2)
     * int(4)
     * long(8)
     * float(4)
     * double(8)
     * char(2)
     * boolean(1)
     *
     */

    @Test
    void testIntRange() {
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        int minusOne = maxValue + minValue;
        assertEquals(0x7fff_ffff, maxValue);
        assertEquals(0b0111_1111_1111_1111_1111_1111_1111_1111, maxValue);
        assertEquals(0x8000_0000, minValue);
        assertEquals(0b1000_0000_0000_0000_0000_0000_0000_0000, minValue);
        assertEquals(0xffff_ffff, minusOne);
        assertEquals(0b1111_1111_1111_1111_1111_1111_1111_1111, minusOne);
    }

    @Test
    void testLongRange() {
        long maxValue = Long.MAX_VALUE;
        long minValue = Long.MIN_VALUE;
        long minusOne = maxValue + minValue;
        assertEquals(0x7fff_ffff_ffff_ffffL, maxValue);
        assertEquals(0x8000_0000_0000_0000L, minValue);
        assertEquals(0xffff_ffff_ffff_ffffL, minusOne);
    }

    @Test
    void someValidLiterals() {
        int[] anIntArray = new int[] {0, 2, 0xDada_Cafe, 1996, 0x00_FF__00_FF, 0b10010};
        long[] aLongArray = new long[] {0L, 0x100000000L, 2_147_483_648L, 0xC0B0L};
        float[] aFloatArray = new float[] {1e1f, 2.f, .3f, 0f, 3.14f, 6.022137e+23f};
        double[] aDoubleArray = new double[] {1e1, 2., .3, 0.0, 3.14, 1e-9d, 1e137};
        boolean[] aBooleanArray = new boolean[] {true, false};
        char[] aCharArray = new char[] {'a', '%', '\t', '\\', '\'', '\u03a9', '\uFFFF', '\177', '™'};
        for (int elem : anIntArray) {
            DisableInspection.doWhatEver(elem);
        }
        for (long elem : aLongArray) {
            DisableInspection.doWhatEver(elem);
        }
        for (float elem : aFloatArray) {
            DisableInspection.doWhatEver(elem);
        }
        for (double elem : aDoubleArray) {
            DisableInspection.doWhatEver(elem);
        }
        for (boolean elem : aBooleanArray) {
            DisableInspection.doWhatEver(elem);
        }
        for (char elem : aCharArray) {
            DisableInspection.doWhatEver(elem);
        }
    }

    @Test
    void testUnsignedValue() {
        // Since Java 8, we can use a unsigned int or long value via some methods provided by
        // Wrapper class
        long longValue = Long.parseUnsignedLong("1234567890123456789");
        assertEquals(Long.toUnsignedString(longValue), "1234567890123456789");
    }

    @Test
    void testOverflow() {
        int maxValue = Integer.MAX_VALUE;
        assertEquals(Integer.MIN_VALUE, maxValue + 1);
    }
}
