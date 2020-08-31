package com.rayyounghong.core.annotations;

import com.rayyounghong.StandardIOTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * {@link AnnotationParsing#main}
 *
 * @author ray
 */
public class AnnotationTest extends StandardIOTest {
    @Test
    void testAnnotation() {
        AnnotationParsing.parseAnnotation();
        assertNotNull(outContent.toString());
        // detail output see AnnotationParsing file
    }
}
