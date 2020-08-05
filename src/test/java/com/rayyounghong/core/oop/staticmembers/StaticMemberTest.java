package com.rayyounghong.core.oop.staticmembers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
public class StaticMemberTest {

    @Test
    public void testStaticBlock() {
        assertEquals(StaticMembers.age, 23);
        assertEquals(StaticMembers.name, "ray");
        assertEquals(StaticMembers.showMessage(), "ray-23");
        // Hint: you can access a static variable via object, but it's not recommended.
    }
}
