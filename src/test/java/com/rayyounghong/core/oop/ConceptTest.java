package com.rayyounghong.core.oop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * check below link to get more information about interface and abstract classes.
 *
 * @author ray
 * @link https://stackoverflow.com/questions/1913098/what-is-the-difference-between-an-interface
 * -and-abstract-class
 * @date 2020/1/19
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
