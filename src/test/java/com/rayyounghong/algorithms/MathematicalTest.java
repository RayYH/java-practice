package com.rayyounghong.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author ray
 * @date 2020/6/22
 */
public class MathematicalTest {
    @Test
    void testGetAllPrimeFactors() {
        assertEquals("[3, 3, 5, 7]", Mathematical.getAllPrimeFactors(315).toString());
        assertEquals("[2]", Mathematical.getAllPrimeFactors(2).toString());
        assertEquals("[11]", Mathematical.getAllPrimeFactors(11).toString());
        assertEquals("[2, 2, 9]", Mathematical.getAllPrimeFactors(36).toString());
        assertEquals("[2, 2, 3]", Mathematical.getAllPrimeFactors(12).toString());
    }

    @Test
    void testSieveOfEratosthenes() {
        assertEquals("[2, 3, 5, 7, 11, 13, 17, 19, 23, 29]", Mathematical.sieveOfEratosthenes(30).toString());
        assertEquals("[2]", Mathematical.sieveOfEratosthenes(2).toString());
        assertEquals("[2, 3]", Mathematical.sieveOfEratosthenes(3).toString());
        assertEquals("[2, 3, 5, 7]", Mathematical.sieveOfEratosthenes(10).toString());
    }

    @Test
    void testLeastPrimeFactor() {
        assertEquals("{1=1, 2=2, 3=3, 4=2, 5=5, 6=2, 7=7, 8=2, 9=3, 10=2}",
            Mathematical.leastPrimeFactor(10).toString());
        assertEquals("{1=1, 2=2, 3=3, 4=2, 5=5, 6=2, 7=7, 8=2, 9=3, 10=2, 11=11, 12=2, 13=13, 14=2}",
            Mathematical.leastPrimeFactor(14).toString());
    }
}
