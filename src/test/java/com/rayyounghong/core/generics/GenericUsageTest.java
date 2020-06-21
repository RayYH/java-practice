package com.rayyounghong.core.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author ray
 * @date 2020/5/9
 */
class GenericUsageTest {

    private static GenericUsage genericUsage;

    @BeforeAll
    static void setup() {
        GenericUsageTest.genericUsage = new GenericUsage();
    }

    @Test
    void testGenericStringList() {
        String result = GenericUsageTest.genericUsage.stringList();
        Assertions.assertEquals(result, "[Ray, Bob]");
    }

    @Test
    void testGenericSingleItem() {
        String result = GenericUsageTest.genericUsage.getSingleItem();
        Assertions.assertEquals(result, "Bob");
    }

    @Test
    void testGenericGetIteratorAsString() {
        String result = GenericUsageTest.genericUsage.getIteratorAsString();
        Assertions.assertEquals(result, "RayBob");
    }
}
