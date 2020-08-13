package com.rayyounghong.algorithms.dp;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class FibonacciTest {
    @Test
    void testFibonacci() {
        Fibonacci f = new Fibonacci();
        assertEquals(0, f.fib(0));
        assertEquals(1, f.fib(1));
        assertEquals(1, f.fib(2));
        assertEquals(2, f.fib(3));
        assertEquals(3, f.fib(4));
        assertEquals(5, f.fib(5));
        assertEquals(8, f.fib(6));
        assertEquals(0, f.fibonacci(0));
        assertEquals(1, f.fibonacci(1));
        assertEquals(1, f.fibonacci(2));
        assertEquals(2, f.fibonacci(3));
        assertEquals(3, f.fibonacci(4));
        assertEquals(5, f.fibonacci(5));
        assertEquals(8, f.fibonacci(6));
    }
}
