package com.rayyounghong.interview.jvm;

/**
 * The bytecode of {@code SimpleObject.class} file:
 *
 * {@code
 * 0 new #8 <com/rayyounghong/interview/jvm/SimpleObject>
 * 3 dup
 * 4 invokespecial #13 <com/rayyounghong/interview/jvm/SimpleObject.<init>>
 * 7 astore_1
 * 8 return
 * }
 *
 * <ul>
 * <li>{@code new} - Create new object</li>
 * <li>{@code dup} - Duplicate the top operand stack value</li>
 * <li>{@code invokespecial} - Invoke instance method; special handling for superclass, private, and instance
 * initialization method invocations</li>
 * <li>{@code astore_n} - Store reference into local variable</li>
 * <li>{@code return} - Return void from method</li>
 * </ul>
 *
 * @author ray
 */
public class SimpleObject {
    int m = 8;

    public static void main(String[] args) {
        SimpleObject s = new SimpleObject();
    }
}
