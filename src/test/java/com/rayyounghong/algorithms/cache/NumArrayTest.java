package com.rayyounghong.algorithms.cache;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class NumArrayTest {
    @Test
    void testRangeSumArrayImmutable() {
        NumArray numArray = new NumArray(new int[] {1, 2, 3, 4, 5});
        assertEquals(1, numArray.sumRange(0, 0));
        assertEquals(3, numArray.sumRange(0, 1));
        assertEquals(15, numArray.sumRange(0, 4));
    }
}
