package com.javaChallenge.apiStartWars.controller;

import com.javaChallenge.apiStartWars.dto.result.ResultFilmDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultFilmNameDTO;
import com.javaChallenge.apiStartWars.service.FilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/films")
public class FilmsController {
    @Autowired
    private FilmsService filmsService;

    @GetMapping("/")
    public ResponseEntity<Page<ResultFilmDTO>> getAllFilms(Pageable pageable){
        return new ResponseEntity<>(filmsService.getAllFilms(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultFilmDTO> getIdFilms(@PathVariable(value = "id",required = false)int id ,
                                                    @RequestParam(value = "name",required = false)String name){
        return new ResponseEntity<>(filmsService.getIdFilms(id,name),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<ResultFilmNameDTO> getNameFilm(@RequestParam(value = "title",required = false)String title){
        return new ResponseEntity<>(filmsService.getNameFilm(title),HttpStatus.OK);
    }
}
