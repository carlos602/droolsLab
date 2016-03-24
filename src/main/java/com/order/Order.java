package com.order;

import java.util.List;

/**
 * Created by masy on 2016/3/18.
 */
public class Order {
    private List<OrderItem> orderItems;
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderItems=" + orderItems +
                '}';
    }
}
