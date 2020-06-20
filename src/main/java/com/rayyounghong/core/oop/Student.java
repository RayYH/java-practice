package com.rayyounghong.core.oop;

/**
 * @author ray
 * @date 2020/1/20
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
