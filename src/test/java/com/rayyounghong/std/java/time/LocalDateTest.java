package com.rayyounghong.std.java.time;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Month;
import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
public class LocalDateTest {

    @Test
    void testLocalDate() {
        // Obtains the current date from the system clock in the default time-zone.
        LocalDate localDate = LocalDate.now();
        assertNotNull(localDate);
        LocalDate day = LocalDate.of(2020, Month.APRIL, 1);
        assertEquals("2020-04-01", day.toString());
        assertEquals(1, day.getDayOfMonth());
        assertEquals(Month.APRIL, day.getMonth());
        assertEquals(2020, day.getYear());
    }
}
