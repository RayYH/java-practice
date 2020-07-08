package com.rayyounghong.core.generics;

/**
 * @author ray
 */
public class Box<T> {
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
