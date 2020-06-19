package com.rayyounghong.core.generics;

/**
 * Simple generic interface.
 *
 * @param <T>
 * @author ray
 */
public interface Generator<T> {

    /**
     * Get next item.
     *
     * @return T
     */
    T next();
}
