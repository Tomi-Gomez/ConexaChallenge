package com.javaChallenge.apiStartWars.dto.planets;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.clients.StarWars.response.starships.StarshipsProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StarshipsPropertiesDTO {
    @JsonProperty("MGLT")
    private String mglt;

    @JsonProperty("cargo_capacity")
    private String cargoCapacity;

    private String consumables;

    @JsonProperty("cost_in_credits")
    private String costInCredits;

    private String created;
    private String crew;
    private String edited;

    @JsonProperty("hyperdrive_rating")
    private String hyperdriveRating;

    private String length;
    private String manufacturer;

    @JsonProperty("max_atmosphering_speed")
    private String maxAtmospheringSpeed;

    private String model;
    private String name;
    private String passengers;

    private List<String> films;
    private List<String> pilots;

    @JsonProperty("starship_class")
    private String starshipClass;

    private String url;

    public static StarshipsPropertiesDTO fromPropertiesStarships(StarshipsProperties response){
        return StarshipsPropertiesDTO.builder()
                .mglt(response.getMglt())
                .cargoCapacity(response.getCargoCapacity())
                .consumables(response.getConsumables())
                .costInCredits(response.getCostInCredits())
                .created(response.getCreated())
                .crew(response.getCrew())
                .edited(response.getEdited())
                .hyperdriveRating(response.getHyperdriveRating())
                .length(response.getLength())
                .manufacturer(response.getManufacturer())
                .maxAtmospheringSpeed(response.getMaxAtmospheringSpeed())
                .model(response.getModel())
                .name(response.getName())
                .passengers(response.getPassengers())
                .films(response.getFilms())
                .pilots(response.getPilots())
                .starshipClass(response.getStarshipClass())
                .url(response.getUrl())
                .build();
    }
}
