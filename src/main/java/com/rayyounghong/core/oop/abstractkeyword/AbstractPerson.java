package com.rayyounghong.core.oop.abstractkeyword;

/**
 * 类即使不含抽象方法，也可以被声明为抽象类。抽象类不能被实例化，但可以定义一个抽象类的对象变量。
 *
 * @author ray
 */
public abstract class AbstractPerson {
    private final String name;

    public AbstractPerson(String name) {
        this.name = name;
    }

    /**
     * Get description of current class.
     *
     * @return string description info.
     */
    public abstract String getDescription();

    public String getName() {
        return this.name;
    }
}
