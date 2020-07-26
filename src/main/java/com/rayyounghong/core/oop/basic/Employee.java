package com.rayyounghong.core.oop.basic;

import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

/**
 * Java does not support finalize method.
 *
 * @author ray
 */
public class Employee {
    private static int nextId;
    private final String name;
    private double salary;
    private final LocalDate hireDay;
    private int id;

    // class initialization block
    static {
        nextId = 1;
    }

    // object initialization block - NOT COMMON
    {
        id = -1;
    }

    public Employee(String name, double salary, int year, Month month, int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public Employee(String name, double salary) {
        this(name, salary, 2000, Month.JANUARY, 1);
    }

    /**
     * Cannot be overridden.
     *
     * @return returns name
     */
    public final String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = Employee.nextId++;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public static int getNextId() {
        return nextId;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + getName() + ",salary=" + getSalary() + ",hireDay=" + hireDay.toString()
            + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee)o;
        return Double.compare(employee.salary, salary) == 0 && name.equals(employee.name)
            && hireDay.equals(employee.hireDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, hireDay);
    }
}
