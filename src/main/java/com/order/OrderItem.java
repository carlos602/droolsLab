package com.order;

/**
 * Created by masy on 2016/3/18.
 */
public class OrderItem {
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "price=" + price +
                '}';
    }
}
