package com.rayyounghong.core.lambda;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class StringFunctionTest {
    public String getFormatted(String str, StringFunction format) {
        return format.run(str);
    }

    @Test
    void testStringFunction() {
        StringFunction exclaim = s -> s + "!";
        StringFunction ask = s -> s + "?";
        assertEquals(getFormatted("Hello", exclaim), "Hello!");
        assertEquals(getFormatted("Hello", ask), "Hello?");

    }
}
