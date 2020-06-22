package com.rayyounghong.ds;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 * @date 2020/6/22
 */
public class RotateArrayTest {
    @Test
    void testLeftRotateSolutionOne() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        RotateArray.leftRotateSolutionOne(arr, 2, 7);
        assertEquals(Arrays.toString(arr), "[3, 4, 5, 6, 7, 1, 2]");
    }

    @Test
    void testLeftRotateSolutionTwo() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        RotateArray.leftRotateSolutionTwo(arr, 2, 7);
        assertEquals(Arrays.toString(arr), "[3, 4, 5, 6, 7, 1, 2]");
    }

    @Test
    void testLeftRotateSolutionThree() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        RotateArray.leftRotateSolutionThree(arr, 2, 7);
        assertEquals(Arrays.toString(arr), "[3, 4, 5, 6, 7, 1, 2]");

        int[] arr2 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        RotateArray.leftRotateSolutionThree(arr2, 3, 12);
        assertEquals(Arrays.toString(arr2), "[4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3]");
    }
}
