package com.rayyounghong.algorithms.mathematical;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class GcdTest {
    @Test
    void gcd() {
        assertEquals(14, Gcd.solutionEuclideanAlgorithm(98, 56));
        assertEquals(3, Gcd.solutionEuclideanAlgorithm(3, 6));
        assertEquals(1, Gcd.solutionEuclideanAlgorithm(3, 116));
        assertEquals(11, Gcd.solutionEuclideanAlgorithm(11, 33));
        assertEquals(3, Gcd.solutionEuclideanAlgorithm(3, 3));

        assertEquals(14, Gcd.gcd(98, 56));
        assertEquals(3, Gcd.gcd(3, 6));
        assertEquals(1, Gcd.gcd(3, 116));
        assertEquals(11, Gcd.gcd(11, 33));
        assertEquals(3, Gcd.gcd(3, 3));

        assertEquals(14, Gcd.gcd(new int[] {98, 56, 14}));
        assertEquals(7, Gcd.gcd(new int[] {98, 56, 14, 7}));
        assertEquals(1, Gcd.gcd(new int[] {98, 56, 14, 7, 3}));
    }
}
