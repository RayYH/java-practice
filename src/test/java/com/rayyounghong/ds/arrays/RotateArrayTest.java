package com.rayyounghong.ds.arrays;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class RotateArrayTest {
    @Test
    void testLeftRotateSolutionViaGcd() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        RotateArray.leftRotateSolutionViaGcd(arr, 2, 7);
        assertEquals(Arrays.toString(arr), "[3, 4, 5, 6, 7, 1, 2]");

        int[] arr2 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        RotateArray.leftRotateSolutionViaGcd(arr2, 3, 12);
        assertEquals(Arrays.toString(arr2), "[4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3]");

        int[] arr3 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        RotateArray.leftRotateSolutionViaGcd(arr3, 36, 12);
        assertEquals(Arrays.toString(arr3), "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]");
    }

    @Test
    void testLeftRotateSolutionViaReverseArray() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        RotateArray.leftRotateSolutionViaReverseArray(arr, 2);
        assertEquals(Arrays.toString(arr), "[3, 4, 5, 6, 7, 1, 2]");

        int[] arr2 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        RotateArray.leftRotateSolutionViaReverseArray(arr2, 3);
        assertEquals(Arrays.toString(arr2), "[4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3]");
    }
}
