package com.rayyounghong.algorithms.mathematical;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 * @date 2020/6/22
 */
public class GcdTest {
    @Test
    void gcd() {
        assertEquals(14, Gcd.solutionTraverseAllDivisors(98, 56));
        assertEquals(3, Gcd.solutionTraverseAllDivisors(3, 6));
        assertEquals(1, Gcd.solutionTraverseAllDivisors(3, 116));

        assertEquals(14, Gcd.solutionEuclideanAlgorithm(98, 56));
        assertEquals(3, Gcd.solutionEuclideanAlgorithm(3, 6));
        assertEquals(1, Gcd.solutionEuclideanAlgorithm(3, 116));

        assertEquals(14, Gcd.solutionEuclideanAlgorithmViaModuloOperator(98, 56));
        assertEquals(3, Gcd.solutionEuclideanAlgorithmViaModuloOperator(3, 6));
        assertEquals(1, Gcd.solutionEuclideanAlgorithmViaModuloOperator(3, 116));
        assertEquals(11, Gcd.solutionEuclideanAlgorithmViaModuloOperator(11, 33));
    }
}
