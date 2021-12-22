package com.lucas.starWars.Service;

import com.lucas.starWars.models.Page;

public interface Service<T>{

    public Page<T> getPage(Integer page);

    public T getById(String path);

}