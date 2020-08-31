package com.rayyounghong.core.annotations.inherited;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author ray
 */
public class InheritedTest {
    @Test
    void testInheritedAnnotation() {
        assertNull(LeverOne.class.getAnnotation(InheritedAnnotationType.class));
        assertEquals("@com.rayyounghong.core.annotations.inherited.InheritedAnnotationType()",
            LevelTwo.class.getAnnotation(InheritedAnnotationType.class).toString());
        assertEquals("@com.rayyounghong.core.annotations.inherited.InheritedAnnotationType()",
            LevelThree.class.getAnnotation(InheritedAnnotationType.class).toString());
        assertEquals("@com.rayyounghong.core.annotations.inherited.UnInheritedAnnotationType()",
            LeverOne.class.getAnnotation(UnInheritedAnnotationType.class).toString());
        assertNull(LevelTwo.class.getAnnotation(UnInheritedAnnotationType.class));
        assertNull(LevelThree.class.getAnnotation(UnInheritedAnnotationType.class));

    }
}
