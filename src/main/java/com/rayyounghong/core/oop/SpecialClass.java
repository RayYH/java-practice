package com.rayyounghong.core.oop;

/**
 * @author ray
 */
public class SpecialClass {

    String name = "special";
    int number = 1;

    /**
     * we normally use static inner class instead of non-static class.
     *
     * We can use private access modifier to modify class, so it cannot be initialized outside outer class.
     */
    class NonStaticClass {
        String name = "non-static";

        public String getFullName() {
            return number + name;
        }
    }

    static class StaticClass {
        String name = "static";
    }

}
