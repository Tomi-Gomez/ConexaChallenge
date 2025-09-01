package com.javaChallenge.apiStartWars.controller;

import com.javaChallenge.apiStartWars.clients.StarWars.response.people.PeopleIdResponse;
import com.javaChallenge.apiStartWars.dto.result.ResultDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultPeopleDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultPeopleNameDTO;
import com.javaChallenge.apiStartWars.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/")
    public ResponseEntity<Page<ResultDTO>> getAllPeople(Pageable pageable){
        return new ResponseEntity<>(peopleService.getAllPeople(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultPeopleDTO> getIdPeople(@PathVariable(value = "id",required = false) int id,
                                                       @RequestParam(value = "name",required = false) String name){
        return new ResponseEntity<>(peopleService.getIdPeople(id,name),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<ResultPeopleNameDTO> getNamePeople(@RequestParam(value = "name") String name){
        return new ResponseEntity<>(peopleService.getNamePeople(name),HttpStatus.OK);
    }

}
