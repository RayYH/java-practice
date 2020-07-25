package com.rayyounghong.core.main;

/**
 * Since we can’t create object of abstract classes in Java, it is guaranteed that object of class with main() is not
 * created by JVM.
 *
 * @author ray
 */
abstract class AbstractMain {
    public static void main(String[] args) {
        System.out.println("main method inside abstract class AbstractMain");
    }
}
