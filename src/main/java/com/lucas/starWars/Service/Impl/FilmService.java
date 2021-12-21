package com.lucas.starWars.Service.Impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lucas.starWars.models.Film;
import com.lucas.starWars.models.Page;

import org.springframework.stereotype.Service;

@Service
public class FilmService extends GenericService<Film> {

    public FilmService() {
        super("https://swapi.dev/api/films", new TypeReference<Page<Film>>() {});
    }
    
}
