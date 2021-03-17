package com.rayyounghong.core.jvm;

/**
 * @author ray
 */
public class StaticStatementsOrder {
    static class Parent {
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        // Output: 2
        System.out.println(Sub.B);
    }
}
