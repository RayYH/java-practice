package com.rayyounghong.core.oop.concretclass;

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
