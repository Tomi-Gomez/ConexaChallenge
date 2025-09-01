package com.javaChallenge.apiStartWars.dto.vehicles;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.dto.result.ResultVehiclesDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiclesNameDTO {
    @JsonProperty("message")
    private String message;

    @JsonProperty("resultDTO")
    private List<ResultVehiclesDTO> resultVehiclesDTOS;
}
