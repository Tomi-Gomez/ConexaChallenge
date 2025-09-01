package com.javaChallenge.apiStartWars.clients.StarWars.response.vehicles;

import com.javaChallenge.apiStartWars.clients.StarWars.response.result.ResultResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiclesResponse {
    @JsonProperty("message")
    private String message;

    @JsonProperty("total_records")
    private int totalRecords;

    @JsonProperty("total_Pages")
    private int totalPages;

    @JsonProperty("previus")
    private String previus;

    @JsonProperty("next")
    private String next;

    @JsonProperty("results")
    private List<ResultResponse> results;
}
