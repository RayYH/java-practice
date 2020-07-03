package com.rayyounghong.core.oop;

/**
 * @author ray
 * @date 2020/7/2
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
