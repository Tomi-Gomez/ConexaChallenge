package com.javaChallenge.apiStartWars.dto.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.clients.StarWars.response.people.ResultPeopleResponse;
import com.javaChallenge.apiStartWars.dto.people.PeoplePropertiesDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultPeopleDTO {
    @JsonProperty("properties")
    private PeoplePropertiesDTO peoplePropertiesDTO;

    @JsonProperty("_id")
    private String id;

    private String description;

    private String uid;

    @JsonProperty("__v")
    private int v;

    public static ResultPeopleDTO fromResultResponse(ResultPeopleResponse response) {
        return ResultPeopleDTO.builder()
                .peoplePropertiesDTO(PeoplePropertiesDTO.fromPropertiesPeople(response.getPeopleProperties()))
                .id(response.getId())
                .description(response.getDescription())
                .uid(response.getUid())
                .v(response.getV())
                .build();
    }
}
