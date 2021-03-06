package com.rayyounghong.core.oop.finalkeyword;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ray
 */
public class FinalTest {
    @Test
    void testFinalKeyword() {
        FinalClass finalClass = new FinalClass();
        FinalMethod finalMethod = new FinalMethod();
        ExtendedClass extendedClass = new ExtendedClass();
        assertEquals(extendedClass.greet(), finalMethod.greet());
        assertNotNull(finalClass);
    }

    @Test
    void testFinalProperties() {
        FinalProperties finalProperties = new FinalProperties();
        assertEquals(finalProperties.i, 1);
        assertEquals(finalProperties.u.name, "Rayyh");
        finalProperties.u.name = "Ray";
        assertEquals(finalProperties.u.name, "Ray");
    }
}
