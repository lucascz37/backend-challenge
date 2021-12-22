package com.lucas.starWars.Service.Impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lucas.starWars.models.Page;
import com.lucas.starWars.models.SWCharacter;
import org.springframework.stereotype.Service;

@Service
public class CharacterService extends GenericService<SWCharacter>{

    public CharacterService() {
        super("https://swapi.dev/api/people", new TypeReference<Page<SWCharacter>>() {}, new TypeReference<SWCharacter>(){});
    }

   
}
