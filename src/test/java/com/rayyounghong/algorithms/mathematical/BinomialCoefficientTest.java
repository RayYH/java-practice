package com.rayyounghong.algorithms.mathematical;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author ray
 */
public class BinomialCoefficientTest {
    @Test
    void testBinomialCoefficient() {
        assertThrows(IllegalArgumentException.class, () -> {
            BinomialCoefficient.binomialCoefficient(1, 2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            BinomialCoefficient.binomialCoefficient(3, -1);
        });
        /*
         * Pascal's triangle:
         *
         * 0:									1
         * 1:								1		1
         * 2:							1		2		1
         * 3:						1		3		3		1
         * 4:					1		4		6		4		1
         * 5:				1		5		10		10		5		1
         * 6:			1		6		15		20		15		6		1
         * 7:		1 		7 		21		35		35		21		7 		1
         * 8:	1 		8 		28		56		70		56		28		8 		1
         */
        assertEquals(1, BinomialCoefficient.binomialCoefficient(0, 0));
        assertEquals(1, BinomialCoefficient.binomialCoefficient(1, 0));
        assertEquals(1, BinomialCoefficient.binomialCoefficient(1, 1));
        assertEquals(1, BinomialCoefficient.binomialCoefficient(2, 0));
        assertEquals(2, BinomialCoefficient.binomialCoefficient(2, 1));
        assertEquals(1, BinomialCoefficient.binomialCoefficient(2, 2));
        assertEquals(1, BinomialCoefficient.binomialCoefficient(8, 0));
        assertEquals(8, BinomialCoefficient.binomialCoefficient(8, 1));
        assertEquals(28, BinomialCoefficient.binomialCoefficient(8, 2));
        assertEquals(56, BinomialCoefficient.binomialCoefficient(8, 3));
        assertEquals(70, BinomialCoefficient.binomialCoefficient(8, 4));
        assertEquals(56, BinomialCoefficient.binomialCoefficient(8, 5));
        assertEquals(28, BinomialCoefficient.binomialCoefficient(8, 6));
        assertEquals(8, BinomialCoefficient.binomialCoefficient(8, 7));
        assertEquals(1, BinomialCoefficient.binomialCoefficient(8, 8));
    }
}
