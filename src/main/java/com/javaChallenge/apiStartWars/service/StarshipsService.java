package com.javaChallenge.apiStartWars.service;

import com.javaChallenge.apiStartWars.dto.result.ResultDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultPeopleDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultStarshipNameDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultStarshipsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StarshipsService {
    public Page<ResultDTO> getAllStarships(Pageable pageable);

    ResultStarshipsDTO getIdStarship(int id, String name);

    ResultStarshipNameDTO getNameStarship(String name);
}
