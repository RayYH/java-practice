package com.rayyounghong.core.oop;

/**
 * @author ray
 */
public class Student extends Person {

    private final float grade;

    public Student(String name, int age, float grade) {
        super(name, age);
        this.grade = grade;
    }

    public float getGrade() {
        return grade;
    }
}
