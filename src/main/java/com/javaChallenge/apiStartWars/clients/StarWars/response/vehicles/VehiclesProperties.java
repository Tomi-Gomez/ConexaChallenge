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
public class VehiclesProperties {
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
}
