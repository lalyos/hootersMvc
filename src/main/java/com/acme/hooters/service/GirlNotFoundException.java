package com.acme.hooters.service;

import org.springframework.core.NestedRuntimeException;

public class GirlNotFoundException extends NestedRuntimeException {

    public GirlNotFoundException(String girlName) {
        super("Girl not found by name:" + girlName);
    }

}
