package com.javaChallenge.apiStartWars.clients.StarWars.response.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class ResultResponse {
    @JsonProperty("uid")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private String url;
}
