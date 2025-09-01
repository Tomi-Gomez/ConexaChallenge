package com.javaChallenge.apiStartWars.dto.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.clients.StarWars.response.people.ResultPeopleResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.starships.ResultStartshipResponse;
import com.javaChallenge.apiStartWars.dto.people.PeoplePropertiesDTO;
import com.javaChallenge.apiStartWars.dto.planets.StarshipsPropertiesDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultStarshipsDTO {
    @JsonProperty("properties")
    private StarshipsPropertiesDTO starshipsPropertiesDTO;

    @JsonProperty("_id")
    private String id;

    private String description;

    private String uid;

    @JsonProperty("__v")
    private int v;

    public static ResultStarshipsDTO fromResultResponse(ResultStartshipResponse response) {
        return ResultStarshipsDTO.builder()
                .starshipsPropertiesDTO(StarshipsPropertiesDTO.fromPropertiesStarships(response.getStarshipsProperties()))
                .id(response.getId())
                .description(response.getDescription())
                .uid(response.getUid())
                .v(response.getV())
                .build();
    }
}
