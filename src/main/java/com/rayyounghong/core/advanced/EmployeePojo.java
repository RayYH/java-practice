package com.rayyounghong.core.advanced;

import java.time.LocalDate;

/**
 * POJO: Plain Old Java Object.
 *
 * @author ray
 * @date 2020/7/1
 */
public class EmployeePojo {

    public String firstName;

    public String lastName;

    private final LocalDate startDate;

    public EmployeePojo(String firstName, String lastName, LocalDate startDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
    }

    public String name() {
        return this.firstName + " " + this.lastName;
    }

    public LocalDate getStart() {
        return this.startDate;
    }
}
