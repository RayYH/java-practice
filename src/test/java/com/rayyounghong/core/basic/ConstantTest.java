package com.rayyounghong.core.basic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 * @date 2020/6/21
 */
public class ConstantTest {
    @Test
    void constantCanBeStaticOrNonStaticInsideClass() {
        assertEquals(ConstantContainer.PI, 3.14);
        assertEquals(new ConstantContainer().getCmPerInch(), 2.54);
    }
}