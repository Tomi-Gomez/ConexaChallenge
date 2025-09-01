package com.javaChallenge.apiStartWars.clients.StarWars.response.film;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    @JsonProperty("_id")
    private String id;

    @JsonProperty("description")
    private String description;

    @JsonProperty("uid")
    private String uid;

    @JsonProperty("__v")
    private int __v;

    @JsonProperty("properties")
    private FilmProperties properties;
}
