package com.javaChallenge.apiStartWars.clients.StarWars.response.vehicles;

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
public class VehiclesNameResponse {
    @JsonProperty("resultDTO")
    private List<ResultVehiclesResponse> resultVehiclesResponses;
}
