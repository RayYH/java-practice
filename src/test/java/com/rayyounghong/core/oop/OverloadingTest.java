package com.rayyounghong.core.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class OverloadingTest {

    @Test
    void testSum() {
        Overloading overloading = new Overloading();
        assertEquals(30, overloading.sum(10, 20));
        assertEquals(60, overloading.sum(10, 20, 30));
        assertEquals(31.0, overloading.sum(10.5, 20.5));
    }

    @Test
    void testShow() {
        Overloading overloading = new Overloading();
        byte aByte = 25;
        assertEquals("byte(25)", overloading.show(aByte));
        assertEquals("String(Hello)", overloading.show("Hello"));
        assertEquals("int(250)", overloading.show(250));
        assertEquals("int(65)", overloading.show('A'));
        assertEquals("String(A)", overloading.show("A"));
    }

    @Test
    void testStaticMethodsCanBeOverloading() {
        assertEquals("Hello, World!", Overloading.getGreeting());
        assertEquals("Hello, Rayyh!", Overloading.getGreeting("Rayyh"));
    }

    Long getLong() {
        return 100L;
    }

    @Test
    void testOverloadingWithAutoboxing() {
        Overloading overloading = new Overloading();
        assertEquals("Primitive int(10)", overloading.autoboxing(10));
        Integer i = 10;
        byte b = 1;
        assertEquals("Reference Integer(10)", overloading.autoboxing(i));
        assertEquals("Primitive long(100)", overloading.autoboxing(100L));
        // notice here, we passed Long wrapper instead of primitive
        assertEquals("Primitive long(100)", overloading.autoboxing(getLong()));
        assertEquals("Primitive int(1)", overloading.autoboxing(b));
        // If compiler fails to find any method corresponding to autoboxing, then it starts searching
        // a method parameter(s) of the widened primitive data type.
        assertEquals("Primitive double(1.2000000476837158)", overloading.autoboxing(1.2f));
    }
}
