package com.rayyounghong.junit5;

import java.time.Duration;
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

    @Test
    void testAssertTimeout() {
        assertTimeout(Duration.ofMinutes(2), () -> {
            // Perform task that takes less than 2 minutes.
        });
        assertTimeout(Duration.ofMillis(2), () -> {
            // Perform task that takes less than 10 ms.
        });
    }
}
