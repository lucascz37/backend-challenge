package com.lucas.starWars.Service.Impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lucas.starWars.models.Page;
import com.lucas.starWars.models.Starship;

import org.springframework.stereotype.Service;

@Service
public class StarshipService extends GenericService<Starship> {

    public StarshipService() {
        super("https://swapi.dev/api/starships", new TypeReference<Page<Starship>>() {}, new TypeReference<Starship>() {});
    }
    
}
