package com.rayyounghong.algorithms.mathematical;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class GcdTest {
    @Test
    void gcd() {
        assertEquals(14, Gcd.solutionTraverseAllDivisors(98, 56));
        assertEquals(3, Gcd.solutionTraverseAllDivisors(3, 6));
        assertEquals(1, Gcd.solutionTraverseAllDivisors(3, 116));

        assertEquals(14, Gcd.solutionChineseRemainderTheorem(98, 56));
        assertEquals(3, Gcd.solutionChineseRemainderTheorem(3, 6));
        assertEquals(1, Gcd.solutionChineseRemainderTheorem(3, 116));

        assertEquals(14, Gcd.solutionEuclideanAlgorithm(98, 56));
        assertEquals(3, Gcd.solutionEuclideanAlgorithm(3, 6));
        assertEquals(1, Gcd.solutionEuclideanAlgorithm(3, 116));
        assertEquals(11, Gcd.solutionEuclideanAlgorithm(11, 33));
    }
}
