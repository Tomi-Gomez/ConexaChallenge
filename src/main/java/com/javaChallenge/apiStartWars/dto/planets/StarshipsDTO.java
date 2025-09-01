package com.javaChallenge.apiStartWars.dto.planets;

import com.javaChallenge.apiStartWars.clients.StarWars.response.starships.StarshipsResponse;
import com.javaChallenge.apiStartWars.dto.result.ResultDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StarshipsDTO {
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

    public StarshipsDTO(StarshipsResponse starshipsResponse, Pageable pageable){
        this.message = starshipsResponse.getMessage();
        this.totalRecords = starshipsResponse.getTotalRecords();
        this.totalPages = starshipsResponse.getTotalPages();
        this.previous = starshipsResponse.getPrevious();
        this.next = starshipsResponse.getNext();

        List<ResultDTO> resultList = starshipsResponse.getResults()
                .stream()
                .map(ResultDTO::fromResultResponse)
                .collect(Collectors.toList());

        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), resultList.size());

        this.results = new PageImpl<>(resultList.subList(start, end), pageable, resultList.size());
    }

}
