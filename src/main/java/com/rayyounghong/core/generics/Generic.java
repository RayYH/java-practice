package com.rayyounghong.core.generics;

/**
 * The diamond operator denotes type inference.
 *
 * <p>
 * naming conversions:
 * </p>
 *
 * <ul>
 * <li>{@code E} − Element, and is mainly used by Java Collections framework.</li>
 * <li>{@code K} − Key, and is mainly used to represent parameter type of key of a map.</li>
 * <li>{@code V} − Value, and is mainly used to represent parameter type of value of a map.</li>
 * <li>{@code N} − Number, and is mainly used to represent numbers.</li>
 * <li>{@code T} − Type, and is mainly used to represent first generic type parameter.</li>
 * <li>{@code S} − Type, and is mainly used to represent second generic type parameter.</li>
 * <li>{@code U} − Type, and is mainly used to represent third generic type parameter.</li>
 * <li>{@code V} − Type, and is mainly used to represent fourth generic type parameter.</li>
 * </ul>
 *
 * <p>
 * Type Erasure Rules:
 * </p>
 *
 * <ul>
 * <li>Replace type parameters in generic type with their bound if bounded type parameters are used.</li>
 * <li>Replace type parameters in generic type with Object if unbounded type parameters are used.</li>
 * <li>Insert type casts to preserve type safety.</li>
 * <li>Generate bridge methods to keep polymorphism in extended generic types.</li>
 * </ul>
 *
 * <ul>
 * <li>Upper bound Wildcard − {@code ? extends Type}.</li>
 * <li>Lower bound Wildcard − {@code ? super Type}.</li>
 * <li>Unbounded Wildcard − {@code ?}</li>
 * </ul>
 *
 * <p>
 * in variable − An in variable provides data to the code. For example, {@code copy(src, dest)}. Here {@code src} acts
 * as in variable being data to be copied.
 * </p>
 * <p>
 * out variable − An out variable holds data updated by the code. For example, {@code copy(src, dest)}. Here {@code
 * dest} acts as in variable having copied data.
 * </p>
 * <ul>
 * <li>Upper bound wildcard − If a variable is of in category, use extends keyword with wildcard.</li>
 * <li>Lower bound wildcard − If a variable is of out category, use super keyword with wildcard.</li>
 * <li>Unbounded wildcard − If a variable can be accessed using Object class method then use an unbound wildcard.</li>
 * <li>No wildcard − If code is accessing variable in both in and out category then do not use wildcards.</li>
 * </ul>
 *
 * <p>
 * Other Points:
 * </p>
 *
 * <ul>
 * <li>No Primitive Types.</li>
 * <li>No Instance: cannot use {@code T item = new T();}.</li>
 * <li>No Static Field: cannot use {@code private static T t;}.</li>
 * <li>No Cast: <a href="https://www.tutorialspoint.com/java_generics/java_generics_no_cast.htm">Java Generics - No
 * Cast</a></li>
 * <li>NO instanceof: <a href="https://www.tutorialspoint.com/java_generics/java_generics_no_instanceof.htm">Java
 * Generics - No instanceOf</a></li>
 * <li>NO Array: cannot use {@code Box<Integer>[] arrayOfLists = new Box<Integer>[2];} - see type erasure.</li>
 * <li>No Exception: A generic class is not allowed to extend the Throwable class directly or indirectly.</li>
 * <li>No Overload: A class is not allowed to have two overloaded methods that can have the same signature after type
 * erasure.</li>
 * </ul>
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
