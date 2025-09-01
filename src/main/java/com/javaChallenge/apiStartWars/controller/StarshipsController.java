package com.javaChallenge.apiStartWars.controller;

import com.javaChallenge.apiStartWars.dto.result.ResultDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultPeopleDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultStarshipNameDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultStarshipsDTO;
import com.javaChallenge.apiStartWars.service.StarshipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/starships")
public class StarshipsController {
    @Autowired
    private StarshipsService starshipsService;

    @GetMapping("/")
    public ResponseEntity<Page<ResultDTO>> getAllStarships(Pageable pageable){
        return new ResponseEntity<>(starshipsService.getAllStarships(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultStarshipsDTO> getIdStarships(@PathVariable(value = "id",required = false) int id,
                                                          @RequestParam(value = "name",required = false) String name){
        return new ResponseEntity<>(starshipsService.getIdStarship(id,name),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<ResultStarshipNameDTO> getNameStarships(@RequestParam(value = "name") String name){
        return new ResponseEntity<>(starshipsService.getNameStarship(name),HttpStatus.OK);
    }
}
