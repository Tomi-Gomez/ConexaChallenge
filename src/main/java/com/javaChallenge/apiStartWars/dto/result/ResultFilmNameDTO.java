package com.javaChallenge.apiStartWars.dto.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.clients.StarWars.response.film.FilmNameResponse;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultFilmNameDTO {
    @JsonProperty("resultDTO")
    private List<ResultFilmDTO> resultFilmDTOS;

    public ResultFilmNameDTO (FilmNameResponse filmNameResponse){
        List<ResultFilmDTO> resultList = filmNameResponse.getResultFilmResponses()
                .stream()
                .map(ResultFilmDTO::fromResultResponse)
                .collect(Collectors.toList());

        this.resultFilmDTOS = resultList;
    }
}
