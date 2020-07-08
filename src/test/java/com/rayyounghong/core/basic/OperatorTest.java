package com.rayyounghong.core.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.rayyounghong.helper.DisableInspection;
import com.rayyounghong.core.oop.Person;
import com.rayyounghong.core.oop.Student;
import com.rayyounghong.helper.DisableInspection;
import com.rayyounghong.helper.container.BooleanContainer;
import com.rayyounghong.helper.container.DoubleContainer;
import com.rayyounghong.helper.container.IntContainer;
import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
class OperatorTest {

    @Test
    void testAssignmentOperator() {
        int anInt = 2;
        int anotherInt = 3;
        assertEquals(anInt, 2);
        assertEquals(anotherInt, 3);
        assertEquals(anotherInt += anInt, 5);
        assertEquals(anotherInt -= anInt, 3);
        assertEquals(anotherInt *= anInt, 6);
        assertEquals(anotherInt /= anInt, 3);
        assertEquals(anotherInt %= anInt, 1);
        assertEquals(anotherInt, 1);
        // there are also &= ^= |= operators not mentioned here.
    }

    /*
     * There are some chinese description I don't want to translate now.
     * When my English is good enough, I'll finish the work.
     */

    @Test
    void testArithmeticOperator() {
        float aFloat = 13.0f / 4;
        assertEquals(3, 1 + 2);
        assertEquals(1, 2 - 1);
        assertEquals(6, 2 * 3);
        assertEquals(3, 13 / 4);
        assertEquals(3.25, aFloat);
        assertEquals(3, 10 % 7);
        assertEquals(7.5, 15.0 / 2);
        // + can also be used to concentrate strings
        assertEquals("Hello World", "Hello" + " " + "World");
    }

    @Test
    void testUnaryOperator() {
        int number = +1;
        assertEquals(1, number);
        number--;
        assertEquals(0, number);
        number++;
        assertEquals(1, number);
        number = -number;
        assertEquals(-1, number);
        BooleanContainer booleanContainer = new BooleanContainer(true, false);
        boolean res = !booleanContainer.boolTwo;
        assertTrue(res);

        int i = 3;
        assertEquals(3, i++);
        assertEquals(4, i);
        assertEquals(4, i--);
        assertEquals(3, i);
        assertEquals(2, --i);
        assertEquals(2, i);
        assertEquals(3, ++i);
        assertEquals(3, i);
    }

    @Test
    void testComparisonOperator() { // also nameed relational operator
        // >, >=, <, <=, !=, ==
        Random random = new Random();
        int i = random.nextInt(3);
        int j = 4 + random.nextInt(3);
        assertNotEquals(i, j);
    }

    @Test
    void testLogicalOperator() {
        Random random = new Random();
        int i = random.nextInt(3);
        int j = 5 + random.nextInt(3);
        boolean bOne = i < 4; // true
        boolean bTwo = j < 4; // false
        assertFalse(bOne && bTwo);
        assertTrue(bOne || bTwo);
    }

    @Test
    /*
     * 1. 计算机使用补码存储
     * 2. 正数的反码和补码都与原码相同 (都等于真值)。
     * 3. 负数的反码为原码符号位不变，其余各位取反；补码为反码 + 1。
     */
    void testBitOperator() {
        // 5 = 0000 0101
        int a = 5;
        // 9 = 0000 1001
        int b = 9;

        /*
         * And
         * 5 & 9
         * 5 = 0000 0101
         * 9 = 0000 1001
         * -------------
         *   = 0000 0001
         *   = 1
         */
        assertEquals(1, a & b);

        /*
         * Or
         *  5 | 9
         * 5 = 0000 0101
         * 9 = 0000 1001
         * -------------
         *   = 0000 1101
         *   = 1 + 4 + 8
         */
        assertEquals(1 + 4 + 8, a | b);

        /*
         * Xor
         * 5 ^ 9
         * 5 = 0000 0101
         * 9 = 0000 1001
         * -------------
         *   = 0000 1100
         *   = 4 + 8
         */
        assertEquals(4 + 8, a ^ b);

        /*
         * Complement
         * 4
         * 0000 0100 - 原码 (正数的原码即为真值)
         * 1111 1011 - 取反，得到的结果在计算机中存储的形式是补码，此补码指示其值是一个负数 (最高位是1)
         * 1111 1010 - -1 (负数的补码由其原码取反 +1 而得，因此我们需要 -1 再对符号位之外的各位取反)
         * 1000 0101 - 取反 (1 + 4)
         *
         * There is a simple rule: A + (~A) = -1
         */
        assertEquals(-(1 + 4), ~4);
    }

    @Test
    void testBitShiftOperator() {
        /*
         * 1. >>  带符号右移运算符，向右移动指定位数 (/2^y)，符号位不变
         * 2. >>> 无符号右移运算符，所有移动的位置都补 0 - 这意味着其作用于正数和 >> 没有什么不同
         * 3. << 表示向左移动移位，在低位补 0 (*2^y)
         */
        // Java 没有 `<<<` 操作符
        Random random = new Random();
        int[] positiveNumbers = new int[10];
        int[] negativeNumbers = new int[10];
        for (int i = 0; i < positiveNumbers.length; i++) {
            int number = random.nextInt(100000);
            positiveNumbers[i] = number;
            negativeNumbers[i] = -number;
        }
        // Positive numbers
        for (int value : positiveNumbers) {
            assertEquals(value / 2, value >> 1);
            assertEquals(value / 2, value >>> 1);
            assertEquals(value * 2, value << 1);
        }
        // Negative numbers - 符号位是 1，由于最后一位会被丢弃，因此如果是奇数，需要考虑丢失的 1 带来的影响
        for (int value : negativeNumbers) {
            if (value % 2 == 0) { // 偶数 - 低位是 0
                assertEquals(value / 2, value >> 1);
                // 由于 >>> 是不带符号的移位操作，因此其势必会变成正数 (符号位会变成 0)
                // 所以其真实的值等于 -(真值/2) + 最大正数值 = (value/2) + 2^(32-1)
                assertEquals((float)(value / 2) + Math.pow(2, Integer.SIZE - 1), value >>> 1);
                assertEquals(value * 2, value << 1);
            } else { // 奇数 - 低位是 1
                assertEquals(value / 2 - 1, value >> 1);
                assertEquals((float)(value / 2 - 1) + Math.pow(2, Integer.SIZE - 1), value >>> 1);
                assertEquals(value * 2, value << 1);
            }
        }
    }

    /*
     * There are also instanceof operator.
     */

    @Test
    void testBitOperatorUsage() {
        Random random = new Random();
        String res;
        int[] positiveNumbers = new int[10];

        for (int i = 0; i < positiveNumbers.length; i++) {
            int number = random.nextInt(100000);
            positiveNumbers[i] = number;
        }

        for (int value : positiveNumbers) {
            // Ternary operator
            res = ((value & 1) == 1) ? " odd" : "even";
            DisableInspection.doWhatEver("[" + res + "] " + value);
        }
    }

    /**
     * true & true == true
     */
    @Test
    public void givenTwoTrueBooleansWhenBitwiseAndOperatorThenTrue() {
        BooleanContainer booleanContainer = new BooleanContainer(true, true);
        boolean trueBool = booleanContainer.boolOne;
        boolean anotherTrueBool = booleanContainer.boolTwo;
        boolean trueANDTrue = trueBool & anotherTrueBool;
        assertTrue(trueANDTrue);
    }

    /**
     * true & false == false
     */
    @Test
    public void givenOneFalseAndOneTrueBooleansWhenBitwiseAndOperatorThenFalse() {
        BooleanContainer booleanContainer = new BooleanContainer(true, false);
        boolean trueBool = booleanContainer.boolOne;
        boolean falseBool = booleanContainer.boolTwo;
        boolean trueANDFalse = trueBool & falseBool;
        assertFalse(trueANDFalse);
    }

    /**
     * false & false == false
     */
    @Test
    public void givenTwoFalseBooleansWhenBitwiseAndOperatorThenFalse() {
        BooleanContainer booleanContainer = new BooleanContainer(false, false);
        boolean falseBool = booleanContainer.boolOne;
        boolean anotherFalseBool = booleanContainer.boolTwo;
        boolean falseAndFalse = falseBool & anotherFalseBool;
        assertFalse(falseAndFalse);
    }

    @Test
    void testInstanceOfOperator() {
        assertFalse(this instanceof Test);
    }

    @Test
    void numberDividedByZero() {
        IntContainer one = new IntContainer(1);
        IntContainer zero = new IntContainer(0);
        assertThrows(ArithmeticException.class, () -> {
            int a = one.intAttr / zero.intAttr;
            DisableInspection.doWhatEver(a);
        });

        DoubleContainer doubleOne = new DoubleContainer(1.0);
        DoubleContainer doubleZero = new DoubleContainer(0.0);
        // 1.0/0=Infinity, 0.0/0=NaN
        double res = doubleOne.doubleAttr / zero.intAttr;
        assertEquals(Double.valueOf(res).toString(), "Infinity");
        assertEquals(0, 1 / res);
        res = doubleZero.doubleAttr / zero.intAttr;
        assertEquals(Double.valueOf(res).toString(), "NaN");
    }
}
