package com.rayyounghong.core.lambda;

/**
 * @author ray
 */
public class Adder extends BaseAdder {
    public void addOne(CustomNumber customNumber) {
        customNumber.number++;
    }

    public static void addTwo(CustomNumber customNumber) {
        customNumber.number += 2;
    }

    public void addThree(CustomNumber customNumber) {
        // super & this keyword
        changeValue(customNumber, super::plusOne);
        changeValue(customNumber, this::addOne);
        changeValue(customNumber, this::addOne);
    }

    public void changeValue(CustomNumber customNumber, ChangeCustomerNumberValue changeCustomerNumberValue) {
        changeCustomerNumberValue.changeValue(customNumber);
    }
}
