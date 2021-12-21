package com.lucas.starWars.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Film {
    private String title;
    @JsonProperty("episode_id")
    private String episode;
    private String director;
    private String producer;
    @JsonProperty("release_date")
    private String releaseDate;
}
