package com.rayyounghong.core.generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 * @date 2020/5/9
 */
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

    @Test
    void showGenericTypeErasure() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> list = new ArrayList<>();
        list.add("Hi");
        assertEquals("[Hi]", list.toString());
        Class<?> c = List.class;
        Method add = c.getDeclaredMethod("add", Object.class);
        add.invoke(list, 123); // notice here: 123, not "123"
        assertEquals("[Hi, 123]", list.toString());
    }
}
