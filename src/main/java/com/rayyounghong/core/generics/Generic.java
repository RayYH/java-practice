package com.rayyounghong.core.generics;

/**
 * The diamond operator denotes type inference.
 *
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

/*
 * E − Element, and is mainly used by Java Collections framework.
 * K − Key, and is mainly used to represent parameter type of key of a map.
 * V − Value, and is mainly used to represent parameter type of value of a map.
 * N − Number, and is mainly used to represent numbers.
 * T − Type, and is mainly used to represent first generic type parameter.
 * S − Type, and is mainly used to represent second generic type parameter.
 * U − Type, and is mainly used to represent third generic type parameter.
 * V − Type, and is mainly used to represent fourth generic type parameter.
 */

/*
 *
 * Upper bound Wildcard − ? extends Type.
 * Lower bound Wildcard − ? super Type.
 * Unbounded Wildcard − ?
 *
 * in variable − An in variable provides data to the code. For example, copy(src, dest). Here src acts as in variable
 *   being data to be copied.
 * out variable − An out variable holds data updated by the code. For example, copy(src, dest). Here dest acts as in
 *  variable having copied data.
 *
 * Upper bound wildcard − If a variable is of in category, use extends keyword with wildcard.
 * Lower bound wildcard − If a variable is of out category, use super keyword with wildcard.
 * Unbounded wildcard − If a variable can be accessed using Object class method then use an unbound wildcard.
 * No wildcard − If code is accessing variable in both in and out category then do not use wildcards.
 */
