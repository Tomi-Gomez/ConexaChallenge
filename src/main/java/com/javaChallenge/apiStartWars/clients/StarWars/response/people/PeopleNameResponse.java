package com.javaChallenge.apiStartWars.clients.StarWars.response.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeopleNameResponse {
    @JsonProperty("resultDTO")
    private List<ResultPeopleResponse> ResultPeopleResponse;
}
