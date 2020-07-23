package com.rayyounghong.junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ray
 */
public class AssertionsTest {
    @Test
    void standardAssertions() {
        assertTrue(true);
        assertFalse(false);
        assertEquals("String", "String");
        assertSame("String", "String");
        assertNotSame("String", new String("String"));
    }
}
