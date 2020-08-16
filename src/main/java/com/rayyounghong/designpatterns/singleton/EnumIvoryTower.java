package com.rayyounghong.designpatterns.singleton;

/**
 * PLEASE VIEW licenses/java-design-patterns-license.txt file to get more details of copyrights.
 *
 * <p>
 * Enum based singleton implementation. Effective Java 2nd Edition (Joshua Bloch) p. 18
 * </p>
 *
 * <p>
 * This implementation is thread safe, however adding any other method and its thread safety is developers
 * responsibility.
 * </p>
 *
 * @author ray
 */
public enum EnumIvoryTower {
    /**
     * Instance.
     */
    INSTANCE;

    @Override
    public String toString() {
        return getDeclaringClass().getCanonicalName() + "@" + hashCode();
    }
}
