package com.rayyounghong.core.pojo;

import java.time.LocalDate;

/**
 * POJO: Plain Old Java Object.
 *
 * @author ray
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
