package com.acme.hooters.service;

import java.util.Collection;

import com.acme.hooters.model.Girl;

public interface GirlRepository {

    public abstract Collection<Girl> getAllGirls();

    public abstract void addGirl(Girl girl);

    public abstract Girl findByName(String name);

    public abstract void remove(String name);

}