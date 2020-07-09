package com.rayyounghong.core.oop;

import java.time.Month;

/**
 * @author ray
 */
public class Manager extends Employee {
    private double bonus;

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public Manager(String name, double salary, int year, Month month, int day) {
        super(name, salary, year, month, day);
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }
}
