package com.rayyounghong.core.basic;

/**
 * Since we can’t create object of abstract classes in Java, it is guaranteed that object of class with main() is not
 * created by JVM.
 *
 * @author ray
 * @date 2020/6/21
 */
abstract class AbstractMain {
    public static void main(String[] args) {
        System.out.println("Main");
    }
}
