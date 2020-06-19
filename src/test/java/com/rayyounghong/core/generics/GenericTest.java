package com.rayyounghong.core.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GenericTest {

    @Test
    void testGeneric() {
        Generic<Integer> genericInteger = new Generic<>(1996);
        Generic<String> genericString = new Generic<>("ray");
        Assertions.assertEquals(genericInteger.getKey(), 1996);
        Assertions.assertEquals(genericString.getKey(), "ray");
        /*
         * You can also use below syntax.
         *
         * the parameter can be "123", 123, false, ...
         * Generic generic = new Generic("123");
         * Assertions.assertEquals(generic.getKey(),"123");
         */
    }
}
