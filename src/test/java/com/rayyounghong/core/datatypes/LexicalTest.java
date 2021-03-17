package com.rayyounghong.core.datatypes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rayyounghong.helper.DisableInspection;
import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
class LexicalTest {
    @Test
    void testIntRange() {
        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;
        int minusOne = maxInt + minInt;
        assertEquals(0x7fff_ffff, maxInt);
        assertEquals(0b0111_1111_1111_1111_1111_1111_1111_1111, maxInt);
        assertEquals(0x8000_0000, minInt);
        assertEquals(0b1000_0000_0000_0000_0000_0000_0000_0000, minInt);
        assertEquals(0xffff_ffff, minusOne);
        assertEquals(0xffff_ffff, -1);
        assertEquals(0b1111_1111_1111_1111_1111_1111_1111_1111, minusOne);
    }

    @Test
    void testLongRange() {
        long maxLong = Long.MAX_VALUE;
        long minLong = Long.MIN_VALUE;
        long minusOne = maxLong + minLong;
        assertEquals(0x7fff_ffff_ffff_ffffL, maxLong);
        assertEquals(0x8000_0000_0000_0000L, minLong);
        assertEquals(0xffff_ffff_ffff_ffffL, minusOne);
    }

    @Test
    void someValidLiterals() {
        int[] anIntArray = new int[] {0, 2, 0xDada_Cafe, 1996, 0x00_FF__00_FF, 0b10010, 5_______2};
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
        // 从 Java 8 开始，我们可以使用 int/long 类型对应的包装类 (Integer/Long) 中的一些方法
        // 来声明一个无符号整数，该无符号整数所能表示的最大值要大于对应类型的有符号整数中的最大值
        long longValue = Long.parseUnsignedLong("1234567890123456789");
        assertEquals(Long.toUnsignedString(longValue), "1234567890123456789");
    }

    @Test
    void testOverflow() {
        int maxValue = Integer.MAX_VALUE;
        assertEquals(Integer.MIN_VALUE, maxValue + 1);
    }
}
