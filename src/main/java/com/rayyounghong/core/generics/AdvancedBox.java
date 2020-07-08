package com.rayyounghong.core.generics;

/**
 * @author ray
 */
public class AdvancedBox<T, S> {
    private T t;
    private S s;

    public void add(T t, S s) {
        this.t = t;
        this.s = s;
    }

    public S getS() {
        return s;
    }

    public T getT() {
        return t;
    }
}
