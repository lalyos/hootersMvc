package com.acme.hooters.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.hooters.model.Girl;

@Component
public class SimpleGirlRepository implements GirlRepository {

    @Autowired
    Map<String, Girl> girlMap = new  ConcurrentHashMap<String, Girl>();
    
    public Collection<Girl> getAllGirls() {
        return girlMap.values();
    }
    
    public void addGirl(Girl girl) {
        girlMap.put(girl.getName(), girl);
    }
    
    public Girl findByName(String name) {
        Girl girl = girlMap.get(name);
        if (girl == null) {
            throw new GirlNotFoundException(name);
        }
        return girl;
    }
    
    public void remove(String name) {
        Girl girl = findByName(name);
        girlMap.remove(girl.getName());
    }
    
}
