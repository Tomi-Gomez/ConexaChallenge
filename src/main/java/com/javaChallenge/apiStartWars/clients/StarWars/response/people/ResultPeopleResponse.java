package com.javaChallenge.apiStartWars.clients.StarWars.response.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultPeopleResponse {
    @JsonProperty("properties")
    private PeopleProperties peopleProperties;

    @JsonProperty("_id")
    private String id;

    private String description;

    private String uid;

    @JsonProperty("__v")
    private int v;
}
