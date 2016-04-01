package com;

import com.order.Order;
import com.order.OrderItem;

import org.kie.api.runtime.KieSession;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by masy on 2016/3/23.
 */

public class TestSpringIntegration {


    public static void main(String[] args) {



        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        KieSession session = (KieSession) context.getBean("order-session");

        Order order = null;
        for (int i = 0; i < 10; i++) {
            List<OrderItem> orderItems = new ArrayList<OrderItem>();
            for (int j = 0; j < 10; j++) {
                OrderItem orderItem = new OrderItem();
                orderItem.setPrice((int) (1 + Math.random() * (20 - 1 + 1)));
                orderItems.add(orderItem);
                // session.insert(orderItem);
            }
            order = new Order();
            order.setOrderItems(orderItems);
            session.insert(order);
        }

        session.fireAllRules();

        System.out.println("=================================================");
        session.insert(order);

        session.getFactHandles();

        session.fireAllRules();
        while (true) ;
    }
}
