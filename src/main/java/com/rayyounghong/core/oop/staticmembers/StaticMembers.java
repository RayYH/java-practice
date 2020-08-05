package com.rayyounghong.core.oop.staticmembers;

/**
 * <ul>
 * <li>Static keyword can be used with class, variable, method and block.</li>
 * <li>Static members belong to the class instead of a specific instance.</li>
 * <li>Static members are common for all the instances(objects) of the class but non-static members are separate for
 * each instance of class.</li>
 * <li>Static block is used for initializing the static variables.This block gets executed when the class is loaded in
 * the memory.</li>
 * <li>A class can have multiple Static blocks, which will execute in the same sequence in which they have been written
 * into the program.</li>
 * <li>Static variables can be accessed directly in Static method.</li>
 * <li>Static Methods can access class variables(static variables) without using object(instance) of the class</li>
 * <li>A class can be made static only if it is a nested class.</li>
 * <li>A static method cannot be abstract at the same time.</li>
 * </ul>
 *
 * @author ray
 */
public class StaticMembers {

    static int age;
    static String name;

    // when class (not object) initialized, will exec statements inside this block.
    static {
        age = 23;
        name = "ray";
    }

    static String showMessage() {
        return name + '-' + age;
    }
}
