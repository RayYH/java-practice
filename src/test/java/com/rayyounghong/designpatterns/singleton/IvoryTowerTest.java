package com.rayyounghong.designpatterns.singleton;

/**
 * @author ray
 */
public class IvoryTowerTest extends SingletonTest<EnumIvoryTower> {
    IvoryTowerTest() {
        super(() -> EnumIvoryTower.INSTANCE);
    }
}
