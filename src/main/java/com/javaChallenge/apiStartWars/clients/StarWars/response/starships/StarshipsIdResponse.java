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
public class StarshipsIdResponse {
    @JsonProperty("message")
    private String message;

    @JsonProperty("resultDTO")
    private ResultStartshipResponse result;
}
