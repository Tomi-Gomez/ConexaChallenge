package com.javaChallenge.apiStartWars.dto.people;

import com.javaChallenge.apiStartWars.clients.StarWars.response.people.PeopleResponse;
import com.javaChallenge.apiStartWars.dto.result.ResultDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class PeopleDTO {
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
    private Page<ResultDTO> results;

    public PeopleDTO(PeopleResponse peopleResponse, Pageable pageable){
        this.message = peopleResponse.getMessage();
        this.totalRecords = peopleResponse.getTotalRecords();
        this.totalPages = peopleResponse.getTotalPages();
        this.previous = peopleResponse.getPrevious();
        this.next = peopleResponse.getNext();


        List<ResultDTO> resultList = peopleResponse.getResults()
                .stream()
                .map(ResultDTO::fromResultResponse)
                .collect(Collectors.toList());

        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), resultList.size());

        this.results = new PageImpl<>(resultList.subList(start, end), pageable, resultList.size());
    }
}
