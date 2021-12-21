package com.lucas.starWars.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Page<T> {
    
    private String next;
    private String previous;
    private List<T> results;
}
