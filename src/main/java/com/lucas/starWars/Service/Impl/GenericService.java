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
    private final TypeReference<Page<T>> pageReference;
    private final TypeReference<T> entityReference;
    private static Logger logger = LoggerFactory.getLogger(GenericService.class);

    public GenericService(String apiURL, TypeReference<Page<T>> pageReference, TypeReference<T> entityReference){
        this.apiURL = apiURL;
        this.pageReference = pageReference;
        this.entityReference = entityReference;
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

        ObjectReader reader = mapper.readerFor(pageReference);

        Page<T> pageResult;

        try{
            pageResult = reader.readValue(result);
        }catch(IOException e){
            logger.error("Error converting to Pojo");
            return null;
        }
        
        return pageResult;
    }

    @Override
    public T getById(String path) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(path, String.class);
        ObjectMapper mapper = new ObjectMapper();

        JsonNode result;

        try{
            result = mapper.readTree(response.getBody());
        }catch(JsonProcessingException e){
            logger.error("Error reading json property");
            return null;
        }

        ObjectReader reader = mapper.readerFor(entityReference);

        T resultEntity;

        try{
            resultEntity = reader.readValue(result);
        }catch(IOException e){
            logger.error("Error converting to Pojo");
            return null;
        }
        
        return resultEntity;
    }
    
}
