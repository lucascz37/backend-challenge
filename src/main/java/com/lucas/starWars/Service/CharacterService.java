package com.lucas.starWars.Service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.lucas.starWars.models.Characters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CharacterService {

    private static final String api = "https://swapi.dev/api/people";
    private static Logger logger = LoggerFactory.getLogger(CharacterService.class);

    public Characters getCharacters(Integer page){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(String.format("%s/?page=%d", api, page), String.class);
        ObjectMapper mapper = new ObjectMapper();

        JsonNode result;
        
        try{
            result = mapper.readTree(response.getBody());
        }catch(JsonProcessingException e){
            logger.error("Error reading json property");
            return null;
        }

        ObjectReader reader = mapper.readerFor(new TypeReference<Characters>() {
        });

        Characters characters;

        try{
            characters = reader.readValue(result);
        }catch(IOException e){
            logger.error("Error converting characters to list");
            return null;
        }
        
        return characters;     
    }
}
