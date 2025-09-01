package com.javaChallenge.apiStartWars.dto.vehicles;

import com.javaChallenge.apiStartWars.clients.StarWars.response.vehicles.VehiclesResponse;
import com.javaChallenge.apiStartWars.dto.result.ResultDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiclesDTO {
    @JsonProperty("message")
    private String message;

    @JsonProperty("total_records")
    private int totalRecords;

    @JsonProperty("total_Pages")
    private int totalPages;

    @JsonProperty("previus")
    private String previus;

    @JsonProperty("next")
    private String next;

    @JsonProperty("results")
    private Page<ResultDTO> results;

    public VehiclesDTO (VehiclesResponse vehiclesResponse, Pageable pageable){
        this.message = vehiclesResponse.getMessage();
        this.totalRecords = vehiclesResponse.getTotalRecords();
        this.totalPages = vehiclesResponse.getTotalPages();
        this.previus = vehiclesResponse.getPrevius();
        this.next = vehiclesResponse.getNext();

        List<ResultDTO> resultList = vehiclesResponse.getResults()
                .stream()
                .map(ResultDTO::fromResultResponse)
                .collect(Collectors.toList());

        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), resultList.size());

        this.results = new PageImpl<>(resultList.subList(start, end), pageable, resultList.size());

    }
}
