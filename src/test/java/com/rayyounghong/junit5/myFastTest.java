package com.rayyounghong.junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 * @date 2020/6/19
 */

public class myFastTest {

    @Fast
    @Test
    void someTest() {
        assertEquals(4, 2 + 2);
    }

    @FastTest
    void anotherTest() {
        assertEquals(5, 1 + 4);
    }
}
