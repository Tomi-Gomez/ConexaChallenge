package com.javaChallenge.apiStartWars.dto.vehicles;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.clients.StarWars.response.starships.StarshipsProperties;
import com.javaChallenge.apiStartWars.clients.StarWars.response.vehicles.VehiclesProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehiclesPropertiesDTO {
    @JsonProperty("created")
    private String created;

    @JsonProperty("edited")
    private String edited;

    @JsonProperty("consumables")
    private String consumables;

    @JsonProperty("name")
    private String name;

    @JsonProperty("cargo_capacity")
    private String cargoCapacity;

    @JsonProperty("passengers")
    private String passengers;

    @JsonProperty("max_atmosphering_speed")
    private String maxAtmospheringSpeed;

    @JsonProperty("crew")
    private String crew;

    @JsonProperty("length")
    private String length;

    @JsonProperty("model")
    private String model;

    @JsonProperty("cost_in_credits")
    private String costInCredits;

    @JsonProperty("manufacturer")
    private String manufacturer;

    @JsonProperty("vehicle_class")
    private String vehicleClass;

    @JsonProperty("pilots")
    private List<String> pilots;

    @JsonProperty("films")
    private List<String> films;

    @JsonProperty("url")
    private String url;

    public static VehiclesPropertiesDTO fromPropertiesVehicles(VehiclesProperties vehiclesProperties){
        return VehiclesPropertiesDTO.builder()
                .created(vehiclesProperties.getCreated())
                .edited(vehiclesProperties.getEdited())
                .consumables(vehiclesProperties.getConsumables())
                .name(vehiclesProperties.getName())
                .cargoCapacity(vehiclesProperties.getCargoCapacity())
                .passengers(vehiclesProperties.getPassengers())
                .maxAtmospheringSpeed(vehiclesProperties.getMaxAtmospheringSpeed())
                .crew(vehiclesProperties.getCrew())
                .length(vehiclesProperties.getLength())
                .model(vehiclesProperties.getModel())
                .costInCredits(vehiclesProperties.getCostInCredits())
                .manufacturer(vehiclesProperties.getManufacturer())
                .vehicleClass(vehiclesProperties.getVehicleClass())
                .pilots(vehiclesProperties.getPilots())
                .films(vehiclesProperties.getFilms())
                .url(vehiclesProperties.getUrl())
                .build();
    }
}
