package com.rayyounghong.core.basic;

import com.rayyounghong.StandardIOTest;
import com.rayyounghong.helper.container.BooleanContainer;
import com.rayyounghong.helper.container.ByteContainer;
import com.rayyounghong.helper.container.CharContainer;
import com.rayyounghong.helper.container.DoubleContainer;
import com.rayyounghong.helper.container.FloatContainer;
import com.rayyounghong.helper.container.IntContainer;
import com.rayyounghong.helper.container.LongContainer;
import com.rayyounghong.helper.container.ShortContainer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author ray
 * @date 2020/6/20
 */
public class PrimitiveDateTypesTest extends StandardIOTest {
    @Test
    void testBoolean() {
        // The boolean data type has two possible values, either true or false.
        BooleanContainer booleanContainer = new BooleanContainer(true, false);
        boolean result = booleanContainer.boolOne;
        assertTrue(result);
    }

    @Test
    void testByte() {
        byte value = 127;
        ByteContainer byteContainer = new ByteContainer(value);
        assertEquals(byteContainer.byteAttr, Byte.MAX_VALUE);
        byteContainer.byteAttr++;
        assertEquals(byteContainer.byteAttr, Byte.MIN_VALUE);
    }

    @Test
    void testShort() {
        short value = 32767;
        ShortContainer shortContainer = new ShortContainer(value);
        assertEquals(shortContainer.shortAttr, Short.MAX_VALUE);
        shortContainer.shortAttr++;
        assertEquals(shortContainer.shortAttr, Short.MIN_VALUE);
    }

    @Test
    void testInt() {
        int value = 2147483647;
        IntContainer intContainer = new IntContainer(value);
        assertEquals(intContainer.intAttr, Integer.MAX_VALUE);
        intContainer.intAttr++;
        assertEquals(intContainer.intAttr, Integer.MIN_VALUE);
    }

    @Test
    void testLong() {
        long value = 9223372036854775807L;
        LongContainer longContainer = new LongContainer(value);
        assertEquals(longContainer.longAttr, Long.MAX_VALUE);
        longContainer.longAttr++;
        assertEquals(longContainer.longAttr, Long.MIN_VALUE);
    }

    @Test
    void testDouble() {
        // double-precision 64-bit floating-point.
        double value = -12.34;
        DoubleContainer doubleContainer = new DoubleContainer(value);
        assertEquals(doubleContainer.doubleAttr, -12.34);
    }

    @Test
    void testFloat() {
        // single-precision 32-bit floating-point.
        float value = -12.34f;
        FloatContainer floatContainer = new FloatContainer(value);
        assertEquals(floatContainer.floatAttr, -12.34f);
    }

    @Test
    void testChar() {
        char value = '9';
        CharContainer charContainer = new CharContainer(value);
        assertEquals(charContainer.charAttr, '9');
        charContainer.charAttr = 65;
        assertEquals(charContainer.charAttr, 'A');
        charContainer.charAttr = '\u0051';
        assertEquals(charContainer.charAttr, 'Q');
        charContainer.charAttr = '\u7231';
        assertEquals(charContainer.charAttr, '爱');
    }
}
