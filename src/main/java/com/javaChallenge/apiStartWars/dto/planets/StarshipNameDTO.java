package com.javaChallenge.apiStartWars.dto.planets;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.dto.result.ResultStarshipsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StarshipNameDTO {
    @JsonProperty("message")
    private String message;

    @JsonProperty("resultDTO")
    private List<ResultStarshipsDTO> resultDTO;
}
