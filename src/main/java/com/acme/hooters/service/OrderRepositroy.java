package com.acme.hooters.service;

import java.util.Collection;

import com.acme.hooters.model.Order;

public interface OrderRepositroy {

    public Collection<Order> getAllOrders();

    public Order findByid(Long id);

}