package com.javaChallenge.apiStartWars.dto.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.clients.StarWars.response.people.PeopleIdResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.people.PeopleResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.result.ResultResponse;
import com.javaChallenge.apiStartWars.dto.result.ResultDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultPeopleDTO;
import lombok.Data;

import java.util.List;

@Data
public class PeopleIdDTO {
    @JsonProperty("message")
    private String message;

    @JsonProperty("resultDTO")
    private ResultPeopleDTO resultDTO;

    public PeopleIdDTO(PeopleIdResponse peopleIdResponse){
        this.message = peopleIdResponse.getMessage();
        this.resultDTO = ResultPeopleDTO.fromResultResponse(peopleIdResponse.getResult());
    }
}
