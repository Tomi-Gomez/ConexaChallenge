package com.javaChallenge.apiStartWars.clients.StarWars.response.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeopleIdResponse {
    @JsonProperty("message")
    private String message;

    @JsonProperty("resultDTO")
    private ResultPeopleResponse result;
}
