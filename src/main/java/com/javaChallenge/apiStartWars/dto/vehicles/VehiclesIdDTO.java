package com.javaChallenge.apiStartWars.dto.vehicles;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.clients.StarWars.response.vehicles.VehiclesIdResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.vehicles.VehiclesResponse;
import com.javaChallenge.apiStartWars.dto.result.ResultVehiclesDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiclesIdDTO {
    @JsonProperty("message")
    private String message;

    @JsonProperty("resultDTO")
    private ResultVehiclesDTO resultVehiclesDTO;

    public VehiclesIdDTO (VehiclesIdResponse vehiclesIdResponse){
        this.message = vehiclesIdResponse.getMessage();
        this.resultVehiclesDTO = ResultVehiclesDTO.fromResultResponse(vehiclesIdResponse.getResult());
    }
}
