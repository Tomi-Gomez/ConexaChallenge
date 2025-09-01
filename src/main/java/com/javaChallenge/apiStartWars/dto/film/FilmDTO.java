package com.javaChallenge.apiStartWars.dto.film;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.clients.StarWars.response.film.FilmResponse;
import com.javaChallenge.apiStartWars.dto.result.ResultFilmDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmDTO {
    @JsonProperty("message")
    private String message;

    @JsonProperty("resultDTO")
    private Page<ResultFilmDTO> results;

    public FilmDTO(FilmResponse filmResponse, Pageable pageable){
        this.message = filmResponse.getMessage();

        List<ResultFilmDTO> resultList = filmResponse.getResults()
                .stream()
                .map(ResultFilmDTO::fromResultResponse)
                .collect(Collectors.toList());

        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), resultList.size());

        this.results = new PageImpl<>(resultList.subList(start, end), pageable, resultList.size());

    }
}
