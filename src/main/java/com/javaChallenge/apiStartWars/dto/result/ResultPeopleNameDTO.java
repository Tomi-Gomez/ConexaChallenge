package com.javaChallenge.apiStartWars.dto.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.clients.StarWars.response.people.PeopleNameResponse;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ResultPeopleNameDTO {
    @JsonProperty("resultDTO")
    private List<ResultPeopleDTO> resultPeopleDTOList;

    public ResultPeopleNameDTO (PeopleNameResponse peopleNameResponse){
        List<ResultPeopleDTO> resultList = peopleNameResponse.getResultPeopleResponse()
                .stream()
                .map(ResultPeopleDTO::fromResultResponse)
                .collect(Collectors.toList());

        this.resultPeopleDTOList = resultList;
    }
}
