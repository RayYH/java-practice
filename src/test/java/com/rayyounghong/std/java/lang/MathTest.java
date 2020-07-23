package com.rayyounghong.std.java.lang;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author ray
 */
public class MathTest {
    @Test
    void constants() {
        assertEquals(2.7182818284590452354, Math.E);
        assertEquals(3.14159265358979323846, Math.PI);
    }

    @Test
    void sin() {
        assertEquals(1, Math.sin(Math.PI / 2));
        // notice here, since PI is a float-point number
        // so we cannot get true result: 0
        assertNotEquals(0, Math.sin(Math.PI));
    }

    @Test
    void cos() {
        assertEquals(1, Math.cos(0));
    }

    @Test
    void tan() {
        assertEquals(1, Math.round(Math.tan(Math.PI / 4) * 10000000 / 10000000));
    }

    @Test
    void atan() {
        assertEquals(Math.PI / 2, Math.atan(Double.POSITIVE_INFINITY));
        assertEquals(-Math.PI / 2, Math.atan(Double.NEGATIVE_INFINITY));
    }

    @Test
    void atan2() {
        // signature: public static double atan2(double y, double x)
        // Four-quadrant inverse tangent
        // 考虑把 x, y 放入坐标系，然后想象成以 sqrt(x^2 + y^2) 为半径作圆即可
        // 值得注意的是，第一个参数是 y，第二个参数使 x
        assertEquals(0.0, Math.atan2(0, 10));
        assertEquals(Math.PI, Math.atan2(0, -10));
        assertEquals(Math.PI / 2, Math.atan2(10, 0));
        assertEquals(-Math.PI / 2, Math.atan2(-10, 0));
        assertEquals(-Math.PI, Math.atan2(-1, Double.NEGATIVE_INFINITY));
    }

    @Test
    void testMathExp() {
        assertEquals(Math.exp(1), Math.E);
    }

    @Test
    void testMathLog() {
        assertEquals(Math.log(Math.E), 1);
    }

    @Test
    void testMathLog10() {
        assertEquals(Math.log10(100), 2);
    }
}
