package com.rayyounghong.core.advanced;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author ray
 */
public class EmployeeBean implements Serializable {

    /**
     * A JavaBean is still a POJO but introduces a strict set of rules around how we implement it.
     *
     * Access levels – our properties are private and we expose getters and setters.
     *
     * Method names – our getters and setters follow the getX and setX convention (in the case of a boolean, isX can be
     * used for a getter).
     *
     * Default Constructor – a no-argument constructor must be present so an instance can be created without providing
     * arguments, for example during deserialization.
     *
     * Serializable – implementing the Serializable interface allows us to store the state.
     *
     * Disadvantages:
     *
     * Mutability – our JavaBeans are mutable due to their setter methods – this could lead to concurrency or
     * consistency issues
     *
     * Boilerplate – we must introduce getters for all properties and setters for most, much of this might be
     * unnecessary Zero-argument
     *
     * Constructor – we often need arguments in our constructors to ensure the object gets instantiated in a valid
     * state, but the JavaBean standard requires us to provide a zero-argument constructor
     *
     */
    private static final long serialVersionUID = -3760445487636086034L;

    private String firstName;

    private String lastName;

    private LocalDate startDate;

    public EmployeeBean() {

    }

    public EmployeeBean(String firstName, String lastName, LocalDate startDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

}
