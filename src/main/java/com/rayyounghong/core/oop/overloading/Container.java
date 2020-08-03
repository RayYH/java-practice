package com.rayyounghong.core.oop.overloading;

/**
 * Java DOSE NOT allow user-defined overloaded operators.
 *
 * Overloading is about same function have different signatures. Overriding is about same function, same signature but
 * different classes connected through inheritance. Overloading is an example of compiler time polymorphism and
 * overriding is an example of run time polymorphism.
 *
 * @author ray
 */
public class Container {
    public int sum(int x, int y) {
        return (x + y);
    }

    public int sum(int x, int y, int z) {
        return (x + y + z);
    }

    public double sum(double x, double y) {
        return (x + y);
    }

    public String show(int x) {
        return "int(" + x + ")";
    }

    public String show(String s) {
        return "String(" + s + ")";
    }

    public String show(byte b) {
        return "byte(" + b + ")";
    }

    public static String getGreeting() {
        return "Hello, World!";
    }

    public static String getGreeting(String name) {
        return "Hello, " + name + "!";
    }

    public String autoboxing(int i) {
        return "Primitive int(" + i + ")";
    }

    public String autoboxing(Integer i) {
        return "Reference Integer(" + i + ")";
    }

    public String autoboxing(long i) {
        return "Primitive long(" + i + ")";
    }

    public String autoboxing(double i) {
        return "Primitive double(" + i + ")";
    }
}
