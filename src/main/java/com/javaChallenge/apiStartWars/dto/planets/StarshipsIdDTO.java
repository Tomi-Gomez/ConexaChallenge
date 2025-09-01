package com.javaChallenge.apiStartWars.dto.planets;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.clients.StarWars.response.people.PeopleIdResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.starships.StarshipsIdResponse;
import com.javaChallenge.apiStartWars.dto.result.ResultPeopleDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultStarshipsDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StarshipsIdDTO {
    @JsonProperty("message")
    private String message;

    @JsonProperty("resultDTO")
    private ResultStarshipsDTO resultDTO;

    public StarshipsIdDTO(StarshipsIdResponse starshipsIdResponse){
        this.message = starshipsIdResponse.getMessage();
        this.resultDTO = ResultStarshipsDTO.fromResultResponse(starshipsIdResponse.getResult());
    }
}
