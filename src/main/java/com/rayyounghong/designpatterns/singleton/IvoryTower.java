package com.rayyounghong.designpatterns.singleton;

/**
 * PLEASE VIEW licenses/java-design-patterns-license.txt file to get more details of copyrights.
 *
 * Singleton class. Eagerly initialized static instance guarantees thread safety.
 *
 * @author ray
 */
public class IvoryTower {
    /**
     * Private constructor so nobody can instantiate the class.
     */
    private IvoryTower() {

    }

    /**
     * Static to class instance of the class.
     */
    private static final IvoryTower INSTANCE = new IvoryTower();

    /**
     * Simple method returns a string.
     *
     * @return string
     */
    public String m() {
        return "m";
    }

    /**
     * To be called by user to obtain instance of the class.
     *
     * @return instance of the singleton.
     */
    public static IvoryTower getInstance() {
        return INSTANCE;
    }
}
