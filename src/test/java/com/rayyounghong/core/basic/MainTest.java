package com.rayyounghong.core.basic;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rayyounghong.StandardIOTest;
import org.junit.jupiter.api.Test;

/**
 * @author ray
 * @date 2020/6/21
 */
public class MainTest extends StandardIOTest {

    @Test
    void testJvmWontCreateObjectOfMainClassSinceMainMethodIsAStaticMethod() {
        AbstractMain.main(new String[] {});
        assertTrue(outContent.toString().startsWith("Main"));
    }
}
