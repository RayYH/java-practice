package com.rayyounghong.algorithms.mathematical;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
public class PrimeFactorTest {
    @Test
    void testGetAllPrimeFactors() {
        assertEquals("[3, 3, 5, 7]", PrimeFactor.getAllPrimeFactors(315).toString());
        assertEquals("[5, 5]", PrimeFactor.getAllPrimeFactors(25).toString());
        assertEquals("[2]", PrimeFactor.getAllPrimeFactors(2).toString());
        assertEquals("[11]", PrimeFactor.getAllPrimeFactors(11).toString());
        assertEquals("[2, 2, 3, 3]", PrimeFactor.getAllPrimeFactors(36).toString());
        assertEquals("[2, 2, 3]", PrimeFactor.getAllPrimeFactors(12).toString());
    }

    @Test
    void testSieveOfEratosthenes() {
        assertEquals("[2, 3, 5, 7, 11, 13, 17, 19, 23, 29]", PrimeFactor.sieveOfEratosthenes(30).toString());
        assertEquals("[2]", PrimeFactor.sieveOfEratosthenes(2).toString());
        assertEquals("[2, 3]", PrimeFactor.sieveOfEratosthenes(3).toString());
        assertEquals("[2, 3, 5, 7]", PrimeFactor.sieveOfEratosthenes(10).toString());
    }

    @Test
    void testLeastPrimeFactor() {
        assertEquals("{1=1, 2=2, 3=3, 4=2, 5=5, 6=2, 7=7, 8=2, 9=3, 10=2}",
            PrimeFactor.leastPrimeFactor(10).toString());
        assertEquals("{1=1, 2=2, 3=3, 4=2, 5=5, 6=2, 7=7, 8=2, 9=3, 10=2, 11=11, 12=2, 13=13, 14=2}",
            PrimeFactor.leastPrimeFactor(14).toString());
    }
}
