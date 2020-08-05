package com.rayyounghong.core.autoboxing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
public class AutoBoxingTest {

    public static int sumOfOddNumber(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            if (i % 2 != 0)
                sum += i;
        }
        return sum;
    }

    @Test
    void testConcept() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        int sumOdd = sumOfOddNumber(list);
        assertEquals(25, sumOdd);
    }

    /**
     * {@code new Integer(123)} will create a new class, while {@code Integer.valueOf(123)} always get a ref to same
     * objects from the cache pool.
     *
     * <ul>
     * <li>boolean values {@code true} and {@code false}</li>
     * <li>all byte values</li>
     * <li>short values between {@code -128} and {@code 127}</li>
     * <li>int values between {@code -128} and {@code 127}</li>
     * <li>char in the range {@code \u0000} to {@code \u007F}</li>
     * </ul>
     *
     * We can use {@code -XX:AutoBoxCacheMax=<size>} to specify the cache size.
     */
    @Test
    void testTwoIntegerObjects() {
        Integer x = 400, y = 400;
        assertNotSame(x, y);
        // In Java, values from -128 to 127 are cached, so the same objects are returned.
        // The implementation of valueOf() uses cached objects if the value is between -128 to 127.
        Integer p = 40, q = 40;
        assertSame(p, q);
        Long xL = 400L, yL = 400L;
        Long zero = 0L;
        assertNotSame(xL, yL);
        assertNotSame(xL + zero, yL);
        assertEquals(xL + zero, yL);
        Long pL = 40L, qL = 40L;
        assertSame(pL, qL);
    }
}
