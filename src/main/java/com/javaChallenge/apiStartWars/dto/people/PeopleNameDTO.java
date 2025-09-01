package com.javaChallenge.apiStartWars.dto.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.clients.StarWars.response.people.PeopleIdResponse;
import com.javaChallenge.apiStartWars.dto.result.ResultPeopleDTO;
import lombok.Data;

import java.util.List;

@Data
public class PeopleNameDTO {
    @JsonProperty("message")
    private String message;

    @JsonProperty("resultDTO")
    private List<ResultPeopleDTO> resultDTO;

}
