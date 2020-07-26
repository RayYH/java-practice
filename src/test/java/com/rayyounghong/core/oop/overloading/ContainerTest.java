package com.rayyounghong.core.oop.overloading;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class ContainerTest {

    @Test
    void testSum() {
        Container container = new Container();
        assertEquals(30, container.sum(10, 20));
        assertEquals(60, container.sum(10, 20, 30));
        assertEquals(31.0, container.sum(10.5, 20.5));
    }

    @Test
    void testShow() {
        Container container = new Container();
        byte aByte = 25;
        assertEquals("byte(25)", container.show(aByte));
        assertEquals("String(Hello)", container.show("Hello"));
        assertEquals("int(250)", container.show(250));
        assertEquals("int(65)", container.show('A'));
        assertEquals("String(A)", container.show("A"));
    }

    @Test
    void testStaticMethodsCanBeOverloading() {
        assertEquals("Hello, World!", Container.getGreeting());
        assertEquals("Hello, Rayyh!", Container.getGreeting("Rayyh"));
    }

    Long getLong() {
        return 100L;
    }

    @Test
    void testOverloadingWithAutoboxing() {
        Container container = new Container();
        assertEquals("Primitive int(10)", container.autoboxing(10));
        Integer i = 10;
        byte b = 1;
        assertEquals("Reference Integer(10)", container.autoboxing(i));
        assertEquals("Primitive long(100)", container.autoboxing(100L));
        // notice here, we passed Long wrapper instead of primitive
        assertEquals("Primitive long(100)", container.autoboxing(getLong()));
        assertEquals("Primitive int(1)", container.autoboxing(b));
        // If compiler fails to find any method corresponding to autoboxing, then it starts searching
        // a method parameter(s) of the widened primitive data type.
        assertEquals("Primitive double(1.2000000476837158)", container.autoboxing(1.2f));
    }
}
