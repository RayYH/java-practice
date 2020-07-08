package com.rayyounghong.core.oop;

/**
 * @author ray
 */
public class FancyCar extends AbstractVehicle implements Driveable {
    @Override
    public String honk() {
        return "beep";
    }
}
