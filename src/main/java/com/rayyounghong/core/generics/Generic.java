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

/*
 * Type Erasure Rules:
 *
 * Replace type parameters in generic type with their bound if bounded type parameters are used.
 * Replace type parameters in generic type with Object if unbounded type parameters are used.
 * Insert type casts to preserve type safety.
 * Generate bridge methods to keep polymorphism in extended generic types.
 */

/*
 * Other Points:
 *
 * No Primitive Types.
 * No Instance: cannot use `T item = new T();`.
 * No Static Field: cannot use `private static T t;`.
 * No Cast: https://www.tutorialspoint.com/java_generics/java_generics_no_cast.htm
 * NO instanceof: https://www.tutorialspoint.com/java_generics/java_generics_no_instanceof.htm
 * NO Array: cannot use `Box<Integer>[] arrayOfLists = new Box<Integer>[2];` - see type erasure.
 * No Exception: A generic class is not allowed to extend the Throwable class directly or indirectly.
 * No Overload: A class is not allowed to have two overloaded methods that can have the same signature after type 
 * erasure.
 */
