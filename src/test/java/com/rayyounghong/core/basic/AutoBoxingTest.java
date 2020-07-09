package com.rayyounghong.core.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
