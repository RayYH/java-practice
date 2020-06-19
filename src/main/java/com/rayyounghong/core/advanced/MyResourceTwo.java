package com.rayyounghong.core.advanced;

import com.rayyounghong.helper.Order;

/**
 * @author ray
 * @date 2020/1/21
 */
public class MyResourceTwo implements AutoCloseable {

    MyResourceTwo() {
        Order.orders.add("Constructor Two.");
    }

    public void doSomething() {
        Order.orders.add("Do Something Two.");
    }

    @Override
    public void close() {
        Order.orders.add("Closed Two.");
    }
}
