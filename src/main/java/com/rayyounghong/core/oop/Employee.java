package com.rayyounghong.core.oop;

import java.time.LocalDate;
import java.time.Month;

/**
 * @author ray
 */
public class Employee {
    private static int nextId;
    private final String name;
    private double salary;
    private final LocalDate hireDay;
    private int id;

    static {
        nextId = 1;
    }

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

    public String getName() {
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
}
