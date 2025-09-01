package com.javaChallenge.apiStartWars.clients.StarWars.response.people;

import com.javaChallenge.apiStartWars.clients.StarWars.response.result.ResultResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeopleResponse {
    @JsonProperty("message")
    private String message;

    @JsonProperty("total_records")
    private int totalRecords;

    @JsonProperty("total_pages")
    private int totalPages;

    @JsonProperty("previous")
    private String previous;

    @JsonProperty("next")
    private String next;

    @JsonProperty("results")
    private List<ResultResponse> results;
}
