package com.javaChallenge.apiStartWars.dto.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.clients.StarWars.response.starships.ResultStartshipResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.vehicles.ResultVehiclesResponse;
import com.javaChallenge.apiStartWars.dto.planets.StarshipsPropertiesDTO;
import com.javaChallenge.apiStartWars.dto.vehicles.VehiclesPropertiesDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultVehiclesDTO {
    @JsonProperty("properties")
    private VehiclesPropertiesDTO vehiclesPropertiesDTO;

    @JsonProperty("_id")
    private String id;

    private String description;

    private String uid;

    @JsonProperty("__v")
    private int v;

    public static ResultVehiclesDTO fromResultResponse(ResultVehiclesResponse response) {
        return ResultVehiclesDTO.builder()
                .vehiclesPropertiesDTO(VehiclesPropertiesDTO.fromPropertiesVehicles(response.getVehiclesProperties()))
                .id(response.getId())
                .description(response.getDescription())
                .uid(response.getUid())
                .v(response.getV())
                .build();
    }
}
