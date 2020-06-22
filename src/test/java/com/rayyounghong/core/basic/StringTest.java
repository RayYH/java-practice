package com.rayyounghong.core.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * @author ray
 * @date 2020/6/22
 */
public class StringTest {

    @Test
    void declareStringViaObjectOrStringLiteral() {
        // `==` checks memory location - assertSame/assertNotSame
        // `equals` checks overridden equals method - assertEquals/assertNotEquals

        // When use new keyword, a String object will be created in heap area
        // (not inside String pooled area)
        String sObjOne = new String("String");
        String sObjTwo = new String("String");
        // Use string literal
        String sConstantOne = "String";
        String sConstantTwo = "String";
        // but: String s1 = null; String s2 = null; ==> s1 == s2 returns true

        assertNotSame(sObjOne, sObjTwo); // == returns false
        assertEquals(sObjOne, sObjTwo); // equals returns true

        assertSame(sConstantOne, sConstantTwo); // == returns true
        assertEquals(sConstantOne, sConstantTwo); // equals returns true
    }
}
