package com.rayyounghong.std.java.util.function;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @see <a href="https://dzone.com/articles/supplier-and-consumer-interface-in-java8">A Look at Java 8's Supplier and
 *      Consumer Interfaces</a>
 * @author ray
 */
public class SupplierTest {
    /**
     * A bean class.
     */
    static class Person {
        private String name;
        private int age;
        private final String address;

        public Person(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }
    }

    @Test
    void test() {
        Supplier<Person> supplier = () -> new Person("Ray", 24, "Web backend developer");
        Person p = supplier.get();
        assertEquals("Ray", p.getName());
        assertEquals(24, p.getAge());
        assertEquals("Web backend developer", p.getAddress());
    }

    @Test
    void testPrimitiveSupplier() {
        IntSupplier intSupplier = () -> 1;
        assertEquals(1, intSupplier.getAsInt());
        LongSupplier longSupplier = () -> 1L;
        assertEquals(1L, longSupplier.getAsLong());
        DoubleSupplier doubleSupplier = () -> 1.1;
        assertEquals(1.1, doubleSupplier.getAsDouble());
        BooleanSupplier booleanSupplier = () -> false;
        assertFalse(booleanSupplier.getAsBoolean());
    }
}
