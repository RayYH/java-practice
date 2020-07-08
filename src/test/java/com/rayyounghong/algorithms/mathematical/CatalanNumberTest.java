package com.rayyounghong.algorithms.mathematical;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
public class CatalanNumberTest {
    @Test
    void testCatalanNumbers() {
        CatalanNumber catalanNumber = new CatalanNumber();
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            l.add(catalanNumber.catalan(i));
        }
        assertEquals("[1, 2, 5, 14, 42, 132, 429, 1430, 4862]", l.toString());
    }
}
