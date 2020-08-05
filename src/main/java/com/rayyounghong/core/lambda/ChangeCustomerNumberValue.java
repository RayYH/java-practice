package com.rayyounghong.core.lambda;

/**
 * @author ray
 */
@FunctionalInterface
interface ChangeCustomerNumberValue {
    /**
     * Change value.
     *
     * @param customNumber
     *            customer number class
     */
    void changeValue(CustomNumber customNumber);
}
