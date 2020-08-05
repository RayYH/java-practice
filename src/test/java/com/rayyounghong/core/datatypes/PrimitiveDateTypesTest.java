package com.rayyounghong.core.datatypes;

import com.rayyounghong.StandardIOTest;
import com.rayyounghong.helper.DisableInspection;
import com.rayyounghong.helper.container.BooleanContainer;
import com.rayyounghong.helper.container.ByteContainer;
import com.rayyounghong.helper.container.CharContainer;
import com.rayyounghong.helper.container.DoubleContainer;
import com.rayyounghong.helper.container.FloatContainer;
import com.rayyounghong.helper.container.IntContainer;
import com.rayyounghong.helper.container.LongContainer;
import com.rayyounghong.helper.container.ShortContainer;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * The primitive types.
 *
 * byte(1) short(2) int(4) long(8) float(4) double(8) char(2) boolean(1)
 *
 * @author ray
 */
public class PrimitiveDateTypesTest extends StandardIOTest {

    /**
     * Although the Java Virtual Machine defines a {@code boolean} type, it only provides very limited support for it.
     * There are no Java Virtual Machine instructions solely dedicated to operations on {@code boolean} values. Instead,
     * expressions in the Java programming language that operate on {@code boolean} values are compiled to use values of
     * the Java Virtual Machine {@code int} data type.
     *
     * The Java Virtual Machine does directly support boolean arrays. Arrays of type boolean are accessed and modified
     * using the byte array instructions <i>baload</i> and <i>bastore</i> ({@code §baload, §bastore}).
     *
     * <a href="https://docs.oracle.com/javase/specs/jvms/se8/jvms8.pdf">The Java® Virtual Machine Specification</a>
     */
    @Test
    void testBoolean() {
        // The boolean data type has two possible values, either true or false.
        BooleanContainer booleanContainer = new BooleanContainer(true, false);
        boolean result = booleanContainer.boolOne;
        assertTrue(result);
        booleanContainer.boolOne = Math.random() > 1;
        booleanContainer.boolTwo = Math.random() > 100000;
        assertEquals(!(booleanContainer.boolOne || booleanContainer.boolTwo),
            !booleanContainer.boolOne && !booleanContainer.boolTwo);
        assertEquals(!(booleanContainer.boolOne && booleanContainer.boolTwo),
            !booleanContainer.boolOne || !booleanContainer.boolTwo);
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
        // see https://en.wikipedia.org/wiki/IEEE_754
        // double-precision 64-bit floating-point.
        // the smallest positive value a double can have is Math.pow(2, -1074), which is equal to 4.9e-324
        double value = -12.34;
        DoubleContainer doubleContainer = new DoubleContainer(value);
        assertEquals(doubleContainer.doubleAttr, -12.34);
        /*
         * a double value has only a limited number of significant bits. If we increase the value of a large double
         * value by only one, we do not change any of the significant bits.
         */
        assertEquals(Double.MAX_VALUE + 1, Double.MAX_VALUE);
        double doubleMax = Double.MAX_VALUE;
        double doubleOne = doubleMax * 2;
        double doubleTwo = doubleMax * -2;
        assertEquals(doubleOne, Double.POSITIVE_INFINITY);
        assertEquals(doubleTwo, Double.NEGATIVE_INFINITY);

        for (int i = 1070; i <= 1074; i++) {
            assertNotEquals(Math.pow(2, -i), 0.0);
        }

        for (int i = 1075; i <= 1080; i++) {
            assertEquals(Math.pow(2, -i), 0.0);
        }

        for (int i = 1075; i <= 1081; i += 2) {
            assertEquals(Math.pow(-2, -i), -0.0);
        }
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
        // some special characters
        assertEquals('\b', '\u0008');
        assertEquals('\t', '\u0009');
    }

    @Test
    void useBigIntegerToHandleIntegerOverflow() {
        BigInteger largeValue = new BigInteger(Integer.MAX_VALUE + "");
        for (int i = 0; i < 4; i++) {
            largeValue = largeValue.add(BigInteger.ONE);
            assertEquals(i + 1, largeValue.intValue() - Integer.MAX_VALUE);
        }
    }

    /**
     * the methods addExact, subtractExact, multiplyExact, and toIntExact throw an ArithmeticException when the results
     * overflow.
     */
    @Test
    void useMethodForExactArithmeticOperators() {
        assertThrows(ArithmeticException.class, () -> {
            int value = Integer.MAX_VALUE;
            value = Math.addExact(value, 1);
            DisableInspection.doWhatEver(value);
        });
    }

    @Test
    void castFromBigIntegerToIntOrLong() {
        BigInteger largeValue = BigInteger.TEN;
        long longValue = largeValue.longValueExact();
        assertEquals(longValue, 10);
        int intValue = largeValue.intValueExact();
        assertEquals(intValue, 10);
    }

    @Test
    void testPositiveAndNegativeZero() {
        double a = +0f;
        double b = -0f;
        DoubleContainer doubleContainerA = new DoubleContainer(a);
        DoubleContainer doubleContainerB = new DoubleContainer(b);
        assertNotEquals(doubleContainerA.doubleAttr, doubleContainerB.doubleAttr);
        BooleanContainer booleanContainer =
            new BooleanContainer(doubleContainerA.doubleAttr == doubleContainerB.doubleAttr, true);
        assertTrue(booleanContainer.boolOne);
        booleanContainer.boolOne = (1 / doubleContainerA.doubleAttr == Double.POSITIVE_INFINITY);
        booleanContainer.boolTwo = (1 / doubleContainerB.doubleAttr == Double.NEGATIVE_INFINITY);
        assertTrue(booleanContainer.boolOne && booleanContainer.boolTwo);
        assertNotEquals(1 / doubleContainerA.doubleAttr, 1 / doubleContainerB.doubleAttr, 0.0);
    }

    /**
     * A compound assignment expression of the form {@code E1 op= E2} is equivalent to{@code  E1 = (T)((E1) op (E2))},
     * where {@code T} is the type of {@code E1}, except that {@code E1} is evaluated only once.
     */
    @Test
    void testCasting() {
        short x = 3;
        x += 4.6;
        assertEquals(x, 7);
    }
}
