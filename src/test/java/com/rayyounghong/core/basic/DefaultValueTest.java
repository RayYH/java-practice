package com.rayyounghong.core.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
class DefaultValueTest {

    /**
     * The variables declared but not initialized in Java will have a default value, initializing a variable when
     * declared it is a best practice.
     */
    @Test
    void testDefaultValue() {
        DefaultValue defaultValue = new DefaultValue();
        Assertions.assertEquals(defaultValue.aByte, 0);
        Assertions.assertEquals(defaultValue.aShort, 0);
        Assertions.assertEquals(defaultValue.anInt, 0);
        Assertions.assertEquals(defaultValue.aLong, 0L);
        Assertions.assertEquals(defaultValue.aFloat, 0.0f);
        Assertions.assertEquals(defaultValue.aDouble, 0.0d);
        Assertions.assertEquals(defaultValue.aChar, '\u0000');
        Assertions.assertNull(defaultValue.aString);
        Assertions.assertFalse(defaultValue.aBoolean);
    }
}
