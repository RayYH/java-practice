package com.rayyounghong.core.oop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
public class StaticDemoTest {

    @Test
    public void testStaticBlock() {
        assertEquals(StaticDemo.age, 23);
        assertEquals(StaticDemo.name, "ray");
        assertEquals(StaticDemo.showMessage(), "ray-23");
        // Hint: you can access a static variable via object, but it's not recommended.
    }
}
