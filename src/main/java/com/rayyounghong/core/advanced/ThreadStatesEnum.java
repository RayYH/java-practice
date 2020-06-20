package com.rayyounghong.core.advanced;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author ray
 * @date 2020/6/20
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

/*
************************************************************************************************************************
 Source: https://www.journaldev.com/716/java-enum

 1. All java enum implicitly extends `java.lang.Enum` class that extends Object class and implements Serializable
    and Comparable interfaces. So we can’t extend any class in enum.
 2. Enum can implement interfaces. As in above enum example, it’s implementing Closeable interface.
 3. Enum constructors are always private, so we can’t create instance of enum using new operator.
 4. We can declare abstract methods in java enum, then all the enum fields must implement the abstract method.
 5. We can define a method in enum and enum fields can override them too.
 6. We can use enum field only with class name like `ThreadStates.START`.
 8. Enums can be used in switch statement.
 9. Enum constants are implicitly static and final, but it’s variable can still be changed.
10. Since enum constants are final, we can safely compare them using “==” and equals() methods.
************************************************************************************************************************
*/
