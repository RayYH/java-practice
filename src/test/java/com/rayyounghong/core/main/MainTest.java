package com.rayyounghong.core.main;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rayyounghong.StandardIOTest;
import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
public class MainTest extends StandardIOTest {

    @Test
    void testJvmWontCreateObjectOfMainClassSinceMainMethodIsAStaticMethod() {
        AbstractMain.main(new String[] {});
        assertTrue(outContent.toString().startsWith("main method inside abstract class AbstractMain"));
    }
}
