package com.javaChallenge.apiStartWars.service.Impl;

import com.javaChallenge.apiStartWars.clients.StarWars.StarwarsClient;
import com.javaChallenge.apiStartWars.clients.StarWars.response.starships.StarshipsIdResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.starships.StarshipsNameResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.starships.StarshipsResponse;
import com.javaChallenge.apiStartWars.dto.planets.StarshipsIdDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultDTO;
import com.javaChallenge.apiStartWars.dto.planets.StarshipsDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultStarshipNameDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultStarshipsDTO;
import com.javaChallenge.apiStartWars.service.StarshipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StarshipsServiceImpl implements StarshipsService {

    @Autowired
    private StarwarsClient starwarsClient;

    public Page<ResultDTO> getAllStarships(Pageable pageable){
        StarshipsResponse starshipsResponse = starwarsClient.getAllResponseStarships();
        return new StarshipsDTO(starshipsResponse, pageable).getResults();
    }

    @Override
    public ResultStarshipsDTO getIdStarship(int id, String name) {
        StarshipsIdResponse starshipsIdResponse = starwarsClient.getIdResponseStarships(id,name);
        return new StarshipsIdDTO(starshipsIdResponse).getResultDTO();
    }

    @Override
    public ResultStarshipNameDTO getNameStarship(String name) {
        StarshipsNameResponse starshipsNameResponse = starwarsClient.getNameResponseStarship(name);
        return new ResultStarshipNameDTO(starshipsNameResponse);
    }


}
