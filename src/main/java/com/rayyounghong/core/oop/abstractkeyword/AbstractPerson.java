package com.rayyounghong.core.oop.abstractkeyword;

/**
 * A class can be abstract even it has no abstract methods. Abstract cass can not be initialized but we can declare a
 * variable whose type is an abstract class.
 *
 * @author ray
 */
public abstract class AbstractPerson {
    private final String name;

    public AbstractPerson(String name) {
        this.name = name;
    }

    /**
     * Get description of current class.
     *
     * @return string description info.
     */
    public abstract String getDescription();

    public String getName() {
        return this.name;
    }
}
