package com.rayyounghong.core.basic;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.rayyounghong.helper.DisableInspection;
import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
public class NullTest {

    private static Object obj;

    @Test
    void anyReferenceVariableInJavaHasDefaultValueNull() {
        assertNull(obj);
    }

    @Test
    void nullValueAssignedToPrimitiveBoxedDataTypeThrowsNullPointerException() {
        Integer i = null;
        assertThrows(NullPointerException.class, () -> {
            int a = i;
            DisableInspection.doWhatEver(a);
        });
    }
}
