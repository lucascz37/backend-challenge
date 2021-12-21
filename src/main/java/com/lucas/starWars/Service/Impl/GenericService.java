package com.lucas.starWars.Service.Impl;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.lucas.starWars.Service.Service;
import com.lucas.starWars.models.Page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GenericService<T> implements Service<T> {

    private final String apiURL;
    private final TypeReference<Page<T>> reference;
    private static Logger logger = LoggerFactory.getLogger(GenericService.class);

    public GenericService(String apiURL, TypeReference<Page<T>> reference){
        this.apiURL = apiURL;
        this.reference = reference;
    }

    @Override
    public Page<T> getPage(Integer page) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(String.format("%s/?page=%d", apiURL, page), String.class);
        ObjectMapper mapper = new ObjectMapper();

        JsonNode result;
        
        try{
            result = mapper.readTree(response.getBody());
        }catch(JsonProcessingException e){
            logger.error("Error reading json property");
            return null;
        }

        ObjectReader reader = mapper.readerFor(reference);

        Page<T> pageResult;

        try{
            pageResult = reader.readValue(result);
        }catch(IOException e){
            logger.error("Error converting characters to list");
            return null;
        }
        
        return pageResult;
    }

    @Override
    public T getById(Integer id) {
        
        return null;
    }
    
}
