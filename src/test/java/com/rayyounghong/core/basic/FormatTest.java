package com.rayyounghong.core.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 * @date 2020/7/2
 */
public class FormatTest {

    @Test
    void testFormatString() {
        assertEquals("159", String.format("%d", 159));
    }

}
