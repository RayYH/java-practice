package com.rayyounghong.core.generics;

/**
 * @author ray
 */
public class NullGenerator<T> implements Generator<T> {

    @Override
    public T next() {
        return null;
    }
}
