package com.rayyounghong.std;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * TODO:
 *
 * @author ray
 * @date 2020/6/21
 */
public class MathTest {
    @Test
    void testMathConstants() {
        assertEquals(Math.E, 2.7182818284590452354);
        assertEquals(Math.PI, 3.14159265358979323846);
    }

    @Test
    void testMathSin() {
        assertEquals(Math.sin(Math.PI / 2), 1);
        // notice here, since PI is a float-point number
        // so we cannot get true result: 0
        assertNotEquals(Math.sin(Math.PI), 0);
    }

    @Test
    void testMathCos() {
        assertEquals(Math.cos(0), 1);
    }

    @Test
    void testMathTan() {
        assertEquals(Math.round(Math.tan(Math.PI / 4) * 10000000 / 10000000), 1);
    }
}
