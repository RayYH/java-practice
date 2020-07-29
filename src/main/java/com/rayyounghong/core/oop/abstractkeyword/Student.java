package com.rayyounghong.core.oop.abstractkeyword;

/**
 * @author ray
 */
public class Student extends AbstractPerson {

    private final String major;

    public Student(String name, String major) {
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return "a student majoring in " + this.major;
    }
}
