package com.rayyounghong.core.oop.basic;

/**
 *
 * <ul>
 * <li>Every class has a constructor whether it’s a normal class or a abstract class.</li>
 * <li>Constructors are not methods and they don’t have any return type.</li>
 * <li>Constructor name should match with class name .</li>
 * <li>Constructor can use any access specifier, they can be declared as private also. Private constructors are possible
 * in java but there scope is within the class only.</li>
 * <li>If you don’t implement any constructor within the class, compiler will do it for.</li>
 * <li>{@code this()} and {@code super()} should be the first statement in the constructor code. If you don’t mention
 * them, compiler does it for you accordingly.</li>
 * <li>Constructor overloading is possible but overriding is not possible.</li>
 * <li>Constructors can not be inherited.</li>
 * <li>If Super class doesn't have a no-arg(default) constructor then compiler would not insert a default constructor in
 * child class as it does in normal scenario.</li>
 * <li>Interfaces do not have constructors, while abstract class can have constructor</li>
 * </ul>
 *
 * <a href="https://beginnersbook.com/2013/03/constructors-in-java/">Constructors in java</a>
 *
 * @author ray
 */
public class Website {

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
