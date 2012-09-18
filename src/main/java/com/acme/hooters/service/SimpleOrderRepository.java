package com.acme.hooters.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.hooters.model.Order;

@Component
public class SimpleOrderRepository implements OrderRepositroy {
    
    @Autowired
    List<Order> orderList;
    
    Map<Long, Order> orderMap = new  ConcurrentHashMap<Long, Order>();
    
    @PostConstruct
    public void init() {
        System.out.println("###\n###\n### init:" + orderList.size());
        for (Order order : orderList) {
            orderMap.put(order.getId(), order);
        }
    }
    
    public Collection<Order> getAllOrders() {
        return orderMap.values();
    }

    public Order findByid(Long id) {
        
        Order order = orderMap.get(id);
        if (order == null) {
            throw new OrderNotFoundException(id);
        }
        return order;
    }
}
