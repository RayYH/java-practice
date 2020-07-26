package com.rayyounghong.core.oop.concretclass;

/**
 * @author ray
 */
public class FancyCar extends AbstractVehicle implements Driveable {
    @Override
    public String honk() {
        return "beep";
    }
}
