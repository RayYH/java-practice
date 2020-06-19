package com.rayyounghong.core.oop;

/**
 * @author ray
 * @date 2020/1/20
 */
public class StaticDemo {
    /*
     * 1. Static keyword can be used with class, variable, method and block.
     * 2. Static members belong to the class instead of a specific instance.
     * 3. Static members are common for all the instances(objects) of the class but non-static
     *    members are separate for each instance of class.
     * 3. Static block is used for initializing the static variables.This block gets executed when
     *    the class is loaded in the memory.
     * 4. A class can have multiple Static blocks, which will execute in the same sequence in which
     *    they have been written into the program.
     * 5. Static variables can be accessed directly in Static method.
     * 6. Static Methods can access class variables(static variables) without using object(instance)
     *    of the class
     * 7. A class can be made static only if it is a nested class.
     */

    static int age;
    static String name;

    static {
        age = 23;
        name = "ray";
    }

    static String showMessage() {
        return name + '-' + age;
    }
}
