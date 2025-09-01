package com.javaChallenge.apiStartWars.dto.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.clients.StarWars.response.people.PeopleProperties;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class PeoplePropertiesDTO {
    private String created;
    private String edited;
    private String name;
    private String gender;

    @JsonProperty("skin_color")
    private String skinColor;

    @JsonProperty("hair_color")
    private String hairColor;

    private String height;

    @JsonProperty("eye_color")
    private String eyeColor;

    private String mass;
    private String homeworld;

    @JsonProperty("birth_year")
    private String birthYear;

    private List<String> vehicles;
    private List<String> starships;
    private List<String> films;
    private String url;

    public static PeoplePropertiesDTO fromPropertiesPeople(PeopleProperties peopleProperties) {
        return PeoplePropertiesDTO.builder()
                .created(peopleProperties.getCreated())
                .edited(peopleProperties.getEdited())
                .name(peopleProperties.getName())
                .gender(peopleProperties.getGender())
                .skinColor(peopleProperties.getSkinColor())
                .hairColor(peopleProperties.getHairColor())
                .height(peopleProperties.getHeight())
                .eyeColor(peopleProperties.getEyeColor())
                .mass(peopleProperties.getMass())
                .homeworld(peopleProperties.getHomeworld())
                .birthYear(peopleProperties.getBirthYear())
                .vehicles(peopleProperties.getVehicles())
                .starships(peopleProperties.getStarships())
                .films(peopleProperties.getFilms())
                .url(peopleProperties.getUrl())
                .build();
    }
}
