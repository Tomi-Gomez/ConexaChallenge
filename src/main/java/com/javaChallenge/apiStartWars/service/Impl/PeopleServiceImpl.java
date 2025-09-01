package com.javaChallenge.apiStartWars.service.Impl;

import com.javaChallenge.apiStartWars.clients.StarWars.response.people.PeopleIdResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.people.PeopleNameResponse;
import com.javaChallenge.apiStartWars.dto.people.PeopleDTO;
import com.javaChallenge.apiStartWars.dto.people.PeopleIdDTO;
import com.javaChallenge.apiStartWars.dto.people.PeopleNameDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultDTO;
import com.javaChallenge.apiStartWars.clients.StarWars.StarwarsClient;
import com.javaChallenge.apiStartWars.clients.StarWars.response.people.PeopleResponse;
import com.javaChallenge.apiStartWars.dto.result.ResultPeopleDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultPeopleNameDTO;
import com.javaChallenge.apiStartWars.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private StarwarsClient starwarsClient;

    @Override
    public Page<ResultDTO> getAllPeople(Pageable pageable) {
         PeopleResponse peopleResponse = starwarsClient.getAllResponsePeople();
         return new PeopleDTO(peopleResponse,pageable).getResults();
    }

    @Override
    public ResultPeopleDTO getIdPeople(int id,String name) {
        PeopleIdResponse peopleIdResponse = starwarsClient.getIdResponsePeople(id,name);
        return new PeopleIdDTO(peopleIdResponse).getResultDTO();
    }

    @Override
    public ResultPeopleNameDTO getNamePeople(String name) {
        PeopleNameResponse peopleNameResponse = starwarsClient.getNameResponsePeople(name);
        return new ResultPeopleNameDTO(peopleNameResponse);
    }

}
