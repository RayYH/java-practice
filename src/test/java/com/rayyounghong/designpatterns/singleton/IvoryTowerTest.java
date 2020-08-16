package com.rayyounghong.designpatterns.singleton;

/**
 * PLEASE VIEW licenses/java-design-patterns-license.txt file to get more details of copyrights.
 *
 * @author ray
 */
public class IvoryTowerTest extends SingletonTest<IvoryTower> {
    /**
     * Create a new singleton test instance using the given 'getInstance' method.
     */
    IvoryTowerTest() {
        super(IvoryTower::getInstance);
    }
}
