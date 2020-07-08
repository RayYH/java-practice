package com.rayyounghong.core.basic;

/**
 * @author ray
 */
public class StaticBlock {
    // code inside static block is executed only once
    // the first time the class is loaded into memory
    // static blocks are executed before constructors
    static {
        System.out.print("static block!");
    }

    StaticBlock() {
        System.out.print(" init ");
    }
}
