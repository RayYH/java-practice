package com.rayyounghong.core.oop;

/**
 * @author ray
 * @date 2020/1/20
 */
public class Website {

    /*
     * see https://beginnersbook.com/2013/03/constructors-in-java/
     *
     * 1. Every class has a constructor whether it’s a normal class or a abstract class.
     * 2. Constructors are not methods and they don’t have any return type.
     * 3. Constructor name should match with class name .
     * 4. Constructor can use any access specifier, they can be declared as private also. Private
     *    constructors are possible in java but there scope is within the class only.
     * 5. If you don’t implement any constructor within the class, compiler will do it for.
     * 6. this() and super() should be the first statement in the constructor code. If you don’t
     *    mention them, compiler does it for you accordingly.
     * 7. Constructor overloading is possible but overriding is not possible.
     * 8. Constructors can not be inherited.
     * 9. If Super class doesn't have a no-arg(default) constructor then compiler would not insert a
     *    default constructor in child class as it does in normal scenario.
     * 10. Interfaces do not have constructors, while abstract class can have constructor
     */

    private final String name;

    private final int visitors;

    public String getName() {
        return name;
    }

    public int getVisitors() {
        return visitors;
    }

    Website() {
        this("rayyounghong.com");
    }

    Website(String name) {
        this(name, 1);
    }

    Website(String name, int visitors) {
        this.name = name;
        this.visitors = visitors;
    }

    Website(Website w) {
        this.name = w.getName();
        this.visitors = w.getVisitors();
    }
}
