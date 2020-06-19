package com.rayyounghong.core.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rayyounghong.helper.BinaryHelper;
import org.junit.jupiter.api.Test;

/**
 * @author ray
 * @date 2020/5/9
 */
public class BinaryNumberTest {

    @Test
    public void testBinaryLiterals() {
        byte five = 0b101;
        assertEquals(five, 5);

        short three = 0b11;
        assertEquals((short) 3, three);

        int nine = 0B1001;
        assertEquals(9, nine);

        long twentyNine = 0B11101;
        assertEquals(29, twentyNine);

        int minusThirtySeven = -0B100101;
        assertEquals(-37, minusThirtySeven);
    }

    @Test
    public void convertToBinaryString() {
        assertEquals("1000", Integer.toBinaryString(8));
        assertEquals("11111", Integer.toBinaryString(31));
    }

    @Test
    public void testOwnConverter() {
        assertEquals(BinaryHelper.convertDecimalToBinary(1000), 1111101000);
        assertEquals(BinaryHelper.convertDecimalToBinary(15), 1111);
        assertEquals(BinaryHelper.convertBinaryToDecimal(1111), 15);
        assertEquals(BinaryHelper.convertBinaryToDecimal(1111101000), 1000);
    }

    @Test
    public void testBinaryToDecimal() {
        assertEquals(8, Integer.parseInt("1000", 2));
        assertEquals(20, Integer.parseInt("10100", 2));
    }
}
