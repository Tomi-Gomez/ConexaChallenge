package com.javaChallenge.apiStartWars.service;

import com.javaChallenge.apiStartWars.dto.people.PeopleDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultPeopleDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultPeopleNameDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PeopleService {
    Page<ResultDTO> getAllPeople(Pageable pageable);

    ResultPeopleDTO getIdPeople(int id,String name);

    ResultPeopleNameDTO getNamePeople(String name);
}
