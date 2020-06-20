package com.rayyounghong.core.basic;

import com.rayyounghong.StandardIOTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author ray
 * @date 2020/6/20
 */
public class HelloWorldTest extends StandardIOTest {

    @Test
    public void out() {
        System.out.print("hello");
        assertEquals("hello", outContent.toString());
    }

    @Test
    public void err() {
        System.err.print("hello again");
        assertEquals("hello again", errContent.toString());
    }

    @Test
    public void testHelloWorld() {
        HelloWorld.main(new String[] {});
        // windows \r\n
        assertTrue(outContent.toString().startsWith("Hello World"));
    }
}
