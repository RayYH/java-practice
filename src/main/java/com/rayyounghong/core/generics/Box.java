package com.rayyounghong.core.generics;

/**
 * @author ray
 * @date 2020/6/22
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
