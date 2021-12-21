package com.lucas.starWars.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SWCharacter {

    private String name;

    private String height;

    @JsonProperty("birth_year")
    private String birthYear;

    private List<String> films;

    @Override
    public String toString() {
        return "SWCharacter [birthYear=" + birthYear + ", height=" + height + ", name=" + name + "]";
    }

    
    
}
