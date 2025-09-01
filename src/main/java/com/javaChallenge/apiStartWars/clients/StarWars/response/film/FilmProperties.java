package com.javaChallenge.apiStartWars.clients.StarWars.response.film;

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
public class FilmProperties {
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
}
