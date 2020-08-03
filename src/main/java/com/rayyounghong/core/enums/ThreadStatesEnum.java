package com.rayyounghong.core.enums;

import java.io.Closeable;
import java.io.IOException;

/**
 * <ol>
 * <li>All java enum implicitly extends {@code java.lang.Enum} class that extends {@link Object} class and implements
 * {@link java.io.Serializable} and {@link Comparable} interfaces. So we can’t extend any class in enum.</li>
 * <li>Enum can implement interfaces. As in above enum example, it’s implementing {@link Closeable} interface.</li>
 * <li>Enum constructors are always private, so we can’t create instance of enum using new operator.</li>
 * <li>We can declare abstract methods in java enum, then all the enum fields must implement the abstract method.</li>
 * <li>We can define a method in enum and enum fields can override them too.</li>
 * <li>We can use enum field only with class name like {@code ThreadStates.START}.</li>
 * <li>Enums can be used in switch statement.</li>
 * <li>Enum constants are implicitly static and final, but it’s variable can still be changed.</li>
 * <li>Since enum constants are final, we can safely compare them using {@code ==} and {@code equals()} methods.</li>
 * <li></li>
 * </ol>
 *
 * @author ray
 * @see <a href="https://www.journaldev.com/716/java-enum">https://www.journaldev.com/716/java-enum</a>
 */
public enum ThreadStatesEnum implements Closeable {
    /**
     * START RUNNING WAITING DEAD
     */
    START(1) {
        @Override
        public String toString() {
            return "START implementation. Priority=" + getPriority();
        }

        @Override
        public String getDetail() {
            return "START";
        }
    },
    RUNNING(2) {
        @Override
        public String getDetail() {
            return "RUNNING";
        }
    },
    WAITING(3) {
        @Override
        public String getDetail() {
            return "WAITING";
        }
    },
    DEAD(4) {
        @Override
        public String getDetail() {
            return "DEAD";
        }
    };

    private int priority;

    public abstract String getDetail();

    /**
     * Enum constructors should always be private.
     *
     * @param i
     *            priority
     */
    private ThreadStatesEnum(int i) {
        priority = i;
    }

    /**
     * Enum can have methods
     *
     * @return priority
     */
    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int p) {
        this.priority = p;
    }

    /**
     * Enum can override functions
     *
     * @return description
     */
    @Override
    public String toString() {
        return "Default ThreadStatesConstructors implementation. Priority=" + getPriority();
    }

    @Override
    public void close() throws IOException {
        System.out.println("Close of Enum");
    }
}
