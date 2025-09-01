package com.javaChallenge.apiStartWars.service.Impl;

import com.javaChallenge.apiStartWars.clients.StarWars.StarwarsClient;
import com.javaChallenge.apiStartWars.clients.StarWars.response.film.FilmIdResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.film.FilmNameResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.film.FilmResponse;
import com.javaChallenge.apiStartWars.dto.film.FilmDTO;
import com.javaChallenge.apiStartWars.dto.film.FilmIdDTO;
import com.javaChallenge.apiStartWars.dto.film.FilmsNameDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultFilmDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultFilmNameDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultPeopleDTO;
import com.javaChallenge.apiStartWars.exception.StarwarsNotFoundException;
import com.javaChallenge.apiStartWars.service.FilmsService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmsServiceImpl implements FilmsService {

    @Autowired
    private StarwarsClient starwarsClient;

    @Override
    public Page<ResultFilmDTO> getAllFilms(Pageable pageable) {
        FilmResponse filmResponse;

        try {
            filmResponse = starwarsClient.getAllResponseFilms();
        } catch (FeignException.NotFound e) {
            throw new StarwarsNotFoundException("Error al consultar la api");
        }

        return new FilmDTO(filmResponse, pageable).getResults();
    }

    @Override
    public ResultFilmDTO getIdFilms(int id, String title) {
        FilmIdResponse filmIdResponse = starwarsClient.getIdResponseFilm(id,title);
        return new FilmIdDTO(filmIdResponse).getResult();
    }

    @Override
    public ResultFilmNameDTO getNameFilm(String title) {
        FilmNameResponse filmNameResponse = starwarsClient.getNameResponseFilm(title);
        return new ResultFilmNameDTO(filmNameResponse);
    }
}
