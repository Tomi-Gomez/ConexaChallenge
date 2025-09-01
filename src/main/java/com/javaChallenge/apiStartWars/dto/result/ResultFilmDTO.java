package com.javaChallenge.apiStartWars.dto.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.clients.StarWars.response.film.FilmProperties;
import com.javaChallenge.apiStartWars.clients.StarWars.response.film.ResultFilmResponse;
import com.javaChallenge.apiStartWars.dto.film.FilmPropertiesDTO;
import com.javaChallenge.apiStartWars.dto.people.PeoplePropertiesDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultFilmDTO {
    @JsonProperty("properties")
    private FilmPropertiesDTO filmPropertiesDTO;

    @JsonProperty("uid")
    private String uid;

    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private String url;

    public static ResultFilmDTO fromResultResponse(ResultFilmResponse response){
        return ResultFilmDTO.builder()
                .filmPropertiesDTO(FilmPropertiesDTO.fromPropertiesFilm(response.getProperties()))
                .uid(response.getUid())
                .title(response.getProperties().getTitle())
                .url(response.getProperties().getUrl())
                .build();
    }

}
