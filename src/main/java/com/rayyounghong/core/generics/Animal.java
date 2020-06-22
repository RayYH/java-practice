package com.rayyounghong.core.generics;

/**
 * @author ray
 * @date 2020/6/22
 */
public class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
