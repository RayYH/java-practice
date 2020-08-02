package com.rayyounghong.core.oop.reflection;

/**
 * @author ray
 */
public class BaseClass {
    public int baseInt;

    private static String method3() {
        return "Method3";
    }

    public String method4() {
        return "Method4";
    }

    public static String method5() {
        return "Method5";
    }

    String method6() {
        return "Method6";
    }

    /**
     * inner public class
     */
    public static class BaseClassInnerClass {}

    /**
     * member public enum
     */
    public enum BaseClassMemberEnum {}
}
