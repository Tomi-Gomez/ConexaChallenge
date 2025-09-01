package com.javaChallenge.apiStartWars.dto.film;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.clients.StarWars.response.film.FilmIdResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.film.ResultFilmResponse;
import com.javaChallenge.apiStartWars.dto.result.ResultFilmDTO;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmIdDTO {
    @JsonProperty("message")
    private String message;

    @JsonProperty("resultDTO")
    private ResultFilmDTO result;

    public FilmIdDTO (FilmIdResponse filmIdResponse){
        this.message=filmIdResponse.getMessage();
        this.result=ResultFilmDTO.fromResultResponse(filmIdResponse.getResult());
    }
}
