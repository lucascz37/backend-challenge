package com.lucas.starWars.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Starship{

    private String name;

    private String model;

    private String manufacturer;

    @JsonProperty("cost_in_credits")
    private String costInCredits;

    @JsonProperty("starship_class")
    private String starshipClass;

    private List<String> pilots;
}