package com.rayyounghong.core.oop.abstractkeyword;

/**
 * @author ray
 */
public class Teacher extends AbstractPerson {
    private final int age;

    public Teacher(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    public String getDescription() {
        return "a teacher of age " + this.age;
    }
}
