package com.javaChallenge.apiStartWars.dto.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.clients.StarWars.response.starships.StarshipsNameResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.vehicles.VehiclesNameResponse;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ResultVehiclesNameDTO {
    @JsonProperty("resultDTO")
    private List<ResultVehiclesDTO> resultVehiclesDTOList;

    public ResultVehiclesNameDTO(VehiclesNameResponse vehiclesNameResponse){
        List<ResultVehiclesDTO> resultList = vehiclesNameResponse.getResultVehiclesResponses()
                .stream()
                .map(ResultVehiclesDTO::fromResultResponse)
                .collect(Collectors.toList());

        this.resultVehiclesDTOList = resultList;
    }
}
