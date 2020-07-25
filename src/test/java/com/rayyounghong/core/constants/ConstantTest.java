package com.rayyounghong.core.constants;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class ConstantTest {
    @Test
    void constantCanBeStaticOrNonStaticInsideClass() {
        assertEquals(ConstantContainer.PI, 3.14);
        assertEquals(new ConstantContainer().getCmPerInch(), 2.54);
    }
}
