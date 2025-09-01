package com.javaChallenge.apiStartWars.clients.StarWars.response.film;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmNameResponse {
    @JsonProperty("resultDTO")
    private List<ResultFilmResponse> resultFilmResponses;
}
