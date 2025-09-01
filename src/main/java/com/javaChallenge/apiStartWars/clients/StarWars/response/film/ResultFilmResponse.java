package com.javaChallenge.apiStartWars.clients.StarWars.response.film;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.clients.StarWars.response.film.Film;
import com.javaChallenge.apiStartWars.clients.StarWars.response.film.FilmProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultFilmResponse {
    @JsonProperty("uid")
    private String uid;

    @JsonProperty("properties")
    private FilmProperties properties;

}
