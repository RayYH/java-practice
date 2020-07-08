package com.rayyounghong.std;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class StringTest {

    @Test
    void charAt() {
        String s = "Hello World!";
        char ch = s.charAt(0);
        assertEquals(ch, 'H');
    }

    @Test
    void codePointAt() {
        // see https://www.compart.com/en/unicode/
        String s = "中国，你好！";
        int cp = s.codePointAt(0);
        // the UTF-16 Encoding of "中" is 0x4E2D
        assertEquals(cp, 0x4E2D);
        // the UTF-16 Encoding of "国" is 0x56FD
        cp = s.codePointAt(1);
        assertEquals(cp, 0x56FD);
    }
}
