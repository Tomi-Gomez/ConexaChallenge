package com.javaChallenge.apiStartWars.dto.film;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaChallenge.apiStartWars.clients.StarWars.response.film.FilmProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilmPropertiesDTO {
    @JsonProperty("created")
    private String created;

    @JsonProperty("edited")
    private String edited;

    @JsonProperty("starships")
    private List<String> starships;

    @JsonProperty("vehicles")
    private List<String> vehicles;

    @JsonProperty("planets")
    private List<String> planets;

    @JsonProperty("producer")
    private String producer;

    @JsonProperty("title")
    private String title;

    @JsonProperty("episode_id")
    private int episode_id;

    @JsonProperty("director")
    private String director;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("opening_crawl")
    private String openingCrawl;

    @JsonProperty("characters")
    private List<String> characters;

    @JsonProperty("species")
    private List<String> species;

    @JsonProperty("url")
    private String url;

    public static FilmPropertiesDTO fromPropertiesFilm(FilmProperties filmProperties){
        return FilmPropertiesDTO.builder()
                .created(filmProperties.getCreated())
                .edited(filmProperties.getEdited())
                .starships(filmProperties.getStarships())
                .vehicles(filmProperties.getVehicles())
                .planets(filmProperties.getPlanets())
                .producer(filmProperties.getProducer())
                .title(filmProperties.getTitle())
                .episode_id(filmProperties.getEpisode_id())
                .director(filmProperties.getDirector())
                .releaseDate(filmProperties.getReleaseDate())
                .openingCrawl(filmProperties.getOpeningCrawl())
                .characters(filmProperties.getCharacters())
                .species(filmProperties.getSpecies())
                .url(filmProperties.getUrl())
                .build();
    }
}
