package com.javaChallenge.apiStartWars.dto.result;

import com.javaChallenge.apiStartWars.clients.StarWars.response.result.ResultResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultDTO {
    @JsonProperty("uid")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private String url;


    public static ResultDTO fromResultResponse(ResultResponse response){
        return ResultDTO.builder()
                .id(response.getId())
                .name(response.getName())
                .url(response.getUrl())
                .build();
    }


}
