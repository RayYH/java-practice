package com.rayyounghong.core.oop.interfaces;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class ComparatorTest {
    @Test
    void test() {
        Person[] people = new Person[9];
        people[0] = new Person();
        people[1] = new Person();
        people[2] = new Person();
        people[3] = new Person();
        people[4] = new Person();
        people[5] = new Person();
        people[6] = new Person();
        people[7] = new Person();
        people[8] = new Person();

        people[0].setFirstName("A");
        people[0].setLastName("A");
        people[1].setFirstName("A");
        people[1].setLastName("B");
        people[2].setFirstName("A");
        people[2].setLastName("C");

        people[3].setFirstName("B");
        people[3].setLastName("A");
        people[4].setFirstName("B");
        people[4].setLastName("B");
        people[5].setFirstName("B");
        people[5].setLastName("C");

        people[6].setFirstName("C");
        people[6].setLastName("B");
        people[7].setFirstName("C");
        people[7].setLastName("AA");
        people[8].setFirstName("C");
        people[8].setLastName("CCC");
        Arrays.sort(people, Comparator.comparing(Person::getFirstName));
        assertEquals("[{A A}, {A B}, {A C}, {B A}, {B B}, {B C}, {C B}, {C AA}, {C CCC}]", Arrays.toString(people));
        Arrays.sort(people, Comparator.comparing(Person::getLastName));
        assertEquals("[{A A}, {B A}, {C AA}, {A B}, {B B}, {C B}, {A C}, {B C}, {C CCC}]", Arrays.toString(people));
        Arrays.sort(people, Comparator.comparing(Person::getLastName, Comparator.comparingInt(String::length)));
        assertEquals("[{A A}, {B A}, {A B}, {B B}, {C B}, {A C}, {B C}, {C AA}, {C CCC}]", Arrays.toString(people));
    }
}
