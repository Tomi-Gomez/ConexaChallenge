package com.javaChallenge.apiStartWars.clients.StarWars.response.starships;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultStartshipResponse {
    @JsonProperty("properties")
    private StarshipsProperties starshipsProperties;

    @JsonProperty("_id")
    private String id;

    private String description;

    private String uid;

    @JsonProperty("__v")
    private int v;
}
