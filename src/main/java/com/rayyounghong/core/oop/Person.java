package com.rayyounghong.core.oop;

import java.util.Date;

/**
 * @author ray
 */
public class Person {

    String name;
    int age;
    Date birthDate;

    /**
     * Constructor has same name as the class and looks like this in a java code.。
     *
     * @param name name
     * @param age  age
     */
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Copy constructor - shallow copy, which is fine since all of our fields – an int and a String
     * in this case – are either primitive types or immutable types.
     *
     * @param p another person.
     */
    Person(Person p) {
        this.age = p.age;
        this.name = p.name;
        // since copy constructor is a shallow copy，so as of birthDate, we need to create an
        // object via new keyword.
        this.birthDate = new Date(p.birthDate.getTime());
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
}
