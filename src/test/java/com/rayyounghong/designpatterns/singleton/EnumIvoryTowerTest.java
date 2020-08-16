package com.rayyounghong.designpatterns.singleton;

/**
 * PLEASE VIEW licenses/java-design-patterns-license.txt file to get more details of copyrights.
 *
 * @author ray
 */
public class EnumIvoryTowerTest extends SingletonTest<EnumIvoryTower> {
    EnumIvoryTowerTest() {
        super(() -> EnumIvoryTower.INSTANCE);
    }
}
