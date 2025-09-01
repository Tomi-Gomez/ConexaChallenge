package com.javaChallenge.apiStartWars.service;

import com.javaChallenge.apiStartWars.dto.result.ResultFilmDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultFilmNameDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultPeopleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FilmsService {
    public Page<ResultFilmDTO> getAllFilms(Pageable pageable);

    public ResultFilmDTO getIdFilms(int id, String title);

    public ResultFilmNameDTO getNameFilm(String title);
}
