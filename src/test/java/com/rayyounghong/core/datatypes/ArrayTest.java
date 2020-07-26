package com.rayyounghong.core.datatypes;

import com.rayyounghong.helper.DisableInspection;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author ray
 */
public class ArrayTest {

    @Test
    void testArrayDeclaration() {
        int[] smallPrimes = {2, 3, 5, 7, 11, 13};
        int[] somePrimes = new int[] {17, 19, 23, 31};
        DisableInspection.doWhatEver(smallPrimes);
        DisableInspection.doWhatEver(somePrimes);
    }

    int[] getNumbers(int[] oldArray) {
        return oldArray;
    }

    @Test
    void testArrayCopy() {
        int[] smallPrimes = {2, 3, 5, 7, 11, 13};
        // modify array value
        smallPrimes[1] = 17;
        assertEquals(17, smallPrimes[1]);
        // 两个变量依然引用同一个数组
        int[] numbers = getNumbers(smallPrimes);
        numbers[0] = 1;
        assertEquals(numbers, smallPrimes);
        // 复制数组可以使用 copyOf
        int[] copiedNumbers = Arrays.copyOf(smallPrimes, smallPrimes.length);
        copiedNumbers[0] = 100;
        assertNotEquals(copiedNumbers, smallPrimes);
    }

    @Test
    void testMultiDimensionalArray() {
        int[][] magicSquare = {{16, 3, 2, 13}, {5, 10, 11, 8}, {9, 5, 2, 1}, {1, 2, 3, 4}};
        assertEquals(16, magicSquare[0][0]);
        assertEquals("[[16, 3, 2, 13], [5, 10, 11, 8], [9, 5, 2, 1], [1, 2, 3, 4]]", Arrays.deepToString(magicSquare));
    }
}
