package com.javaChallenge.apiStartWars.dto.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.clients.StarWars.response.people.PeopleNameResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.starships.StarshipsNameResponse;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ResultStarshipNameDTO {
    @JsonProperty("resultDTO")
    private List<ResultStarshipsDTO> resultStarchipDTOList;

    public ResultStarshipNameDTO(StarshipsNameResponse starshipsNameResponse){
        List<ResultStarshipsDTO> resultList = starshipsNameResponse.getResultStartshipResponse()
                .stream()
                .map(ResultStarshipsDTO::fromResultResponse)
                .collect(Collectors.toList());

        this.resultStarchipDTOList = resultList;
    }
}
