package com.rayyounghong.core.annotations;

import com.rayyounghong.StandardIOTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class AnnotationTest extends StandardIOTest {
    @Test
    void testAnnotation() {
        AnnotationParsing.parseAnnotation();
        String s =
            "Annotation in Method "
                + "'public java.lang.String com.rayyounghong.core.annotations.AnnotationExample.toString()' : @com.rayyounghong.core.annotations.MethodInfo(author=\"Ray\", revision=2, comments=\"Main method\", date=\"Jun 20 2020\")\n"
                + "revision: 2\n"
                + "Annotation in Method 'public static void com.rayyounghong.core.annotations.AnnotationExample.oldMethod()' : @java.lang.Deprecated(forRemoval=false, since=\"\")\n"
                + "Annotation in Method 'public static void com.rayyounghong.core.annotations.AnnotationExample.oldMethod()' : @com.rayyounghong.core.annotations.MethodInfo(author=\"Rayyh\", revision=1, comments=\"deprecated method\", date=\"Jun 20 2020\")\n"
                + "revision: 1\n"
                + "Annotation in Method 'public static void com.rayyounghong.core.annotations.AnnotationExample.genericsTest()' : @com.rayyounghong.core.annotations.MethodInfo(author=\"Ray\", revision=10, comments=\"Main method\", date=\"Jun 20 2020\")\n"
                + "revision: 10\n";
        assertEquals(s, outContent.toString());
    }
}
