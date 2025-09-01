package com.javaChallenge.apiStartWars.dto.film;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.dto.result.ResultFilmDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmsNameDTO {
    @JsonProperty("message")
    private String message;

    @JsonProperty("resultDTO")
    private List<ResultFilmDTO> resultDTO;
}
