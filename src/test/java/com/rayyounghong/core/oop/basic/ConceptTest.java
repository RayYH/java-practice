package com.rayyounghong.core.oop.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * check below link to get more information about interface and abstract classes.
 *
 * <p>
 * Execution order:
 * </p>
 * <ul>
 * <li>Base class (static members, blocks)</li>
 * <li>Sub Class (static members, blocks)</li>
 * <li>Base class (instance members, regular statements)</li>
 * <li>Base class (constructors)</li>
 * <li>Sub Class (instance members, regular statements)</li>
 * <li>Sub Class (constructors)</li>
 * </ul>
 *
 * <a href="https://stackoverflow.com/questions/1913098/what-is-the-difference-between-an-interface-and-abstract-class">
 * What is the difference between an interface and abstract class?</a>
 *
 * @author ray
 */
public class ConceptTest {
    @Test
    void testPerson() {
        Person person = new Person("ray", 23);
        assertEquals("ray", person.getName());
        assertEquals(23, person.getAge());
        person.setName("rayyh");
        person.setAge(24);
        assertEquals("rayyh", person.getName());
        assertEquals(24, person.getAge());
    }
}
