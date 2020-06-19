package com.rayyounghong.core.generics;

/**
 * @param <T>
 * @author ray
 */
class Generic<T> {

    private final T key;

    Generic(T key) {
        this.key = key;
    }

    T getKey() {
        return key;
    }
}
