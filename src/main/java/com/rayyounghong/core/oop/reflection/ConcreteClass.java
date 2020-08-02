package com.rayyounghong.core.oop.reflection;

/**
 * @author ray
 */

@Deprecated
public class ConcreteClass extends BaseClass implements BaseInterface {
    public int publicInt;
    private final String privateString = "private string";
    protected boolean protectedBoolean;
    Object defaultObject;

    public ConcreteClass(int i) {
        this.publicInt = i;
    }

    @Override
    public String method1() {
        return "Method1 impl.";
    }

    @Override
    public String method2(String str) {
        return "Method2 impl.";
    }

    @Override
    public String method4() {
        return "Method4 overridden.";
    }

    public String method5(int i) {
        return "Method4 overridden.";
    }

    public static class ConcreteClassPublicClass {}

    private static class ConcreteClassPrivateClass {}

    protected static class ConcreteClassProtectedClass {}

    static class ConcreteClassDefaultClass {}

    enum ConcreteClassDefaultEnum {}

    public enum ConcreteClassPublicEnum {}

    public interface ConcreteClassPublicInterface {}
}
