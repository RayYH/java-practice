package com.rayyounghong.algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 * @date 2020/6/22
 */
public class DivisorTest {

    @Test
    void divisor() {
        assertEquals("[1, 2, 50, 4, 20, 100, 5, 25, 10]", Divisor.solutionOne(100).toString());
        assertEquals("[1, 2, 3, 6]", Divisor.solutionOne(6).toString());
        assertEquals("[1, 2, 50, 100, 4, 20, 5, 25, 10]", Divisor.solutionTwo(100).toString());
        assertEquals("[1, 2, 3, 6]", Divisor.solutionTwo(6).toString());
        assertEquals("[1, 2, 4, 5, 10, 20, 25, 50, 100]", Divisor.solutionThree(100).toString());
        assertEquals("[1, 2, 3, 6]", Divisor.solutionThree(6).toString());
    }
}
