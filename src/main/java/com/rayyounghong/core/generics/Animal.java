package com.rayyounghong.core.generics;

/**
 * @author ray
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
