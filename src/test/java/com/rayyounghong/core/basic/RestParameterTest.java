package com.rayyounghong.core.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
public class RestParameterTest {

    @Test
    void testMax() {
        assertEquals(40.4, RestParameter.max(-1, 3.5, 40.4, 2.78));
    }
}
