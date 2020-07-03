package com.rayyounghong.core.oop;

/**
 * @author ray
 * @date 2020/7/2
 */
public class FancyCar extends AbstractVehicle implements Driveable {
    @Override
    public String honk() {
        return "beep";
    }
}
