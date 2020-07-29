package com.rayyounghong.core.oop.objectclass;

import java.util.Objects;

/**
 * @author ray
 */
public class Person {
    private final String name;
    private final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public boolean equals(Object o) {
        // 引用同一个对象，则返回 true
        if (this == o) {
            return true;
        }
        // 如果对象为 null 或者不属于同一个类，返回 false
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        // 显示转换 o 的类型
        Person person = (Person)o;
        // 对需要进行比较的域进行比较
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
