package com.acme.hooters.service;

import org.springframework.core.NestedRuntimeException;

public class OrderNotFoundException extends NestedRuntimeException {

    public OrderNotFoundException(Long id) {
        super("Order not found by id:" + id);
    }

}
