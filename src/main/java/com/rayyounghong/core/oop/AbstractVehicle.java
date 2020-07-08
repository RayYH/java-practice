package com.rayyounghong.core.oop;

/**
 * @author ray
 */
public abstract class AbstractVehicle {

    /**
     * Hook.
     *
     * @return a string.
     */
    public abstract String honk();

    public String drive() {
        return "zoom";
    }
}
