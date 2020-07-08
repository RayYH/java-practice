package com.rayyounghong.ds.arrays;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
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

        int[] arr3 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        RotateArray.leftRotateSolutionThree(arr3, 36, 12);
        assertEquals(Arrays.toString(arr3), "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]");
    }

    @Test
    void testLeftRotateSolutionFour() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        RotateArray.leftRotateSolutionFour(arr, 2);
        assertEquals(Arrays.toString(arr), "[3, 4, 5, 6, 7, 1, 2]");

        int[] arr2 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        RotateArray.leftRotateSolutionFour(arr2, 3);
        assertEquals(Arrays.toString(arr2), "[4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3]");
    }

    @Test
    void testLeftRotateSolutionFive() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        RotateArray.leftRotateSolutionFive(arr, 2, 7);
        assertEquals(Arrays.toString(arr), "[3, 4, 5, 6, 7, 1, 2]");

        int[] arr2 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        RotateArray.leftRotateSolutionFive(arr2, 3, 12);
        assertEquals(Arrays.toString(arr2), "[4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3]");

        int[] arr3 = new int[] {1, 2, 3, 4, 5, 6, 7};
        RotateArray.leftRotateSolutionFive(arr3, 3, 7);
        assertEquals(Arrays.toString(arr3), "[4, 5, 6, 7, 1, 2, 3]");
    }
}
