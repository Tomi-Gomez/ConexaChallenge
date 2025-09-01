package com.javaChallenge.apiStartWars.unitario.service;

import com.javaChallenge.apiStartWars.clients.StarWars.StarwarsClient;
import com.javaChallenge.apiStartWars.clients.StarWars.response.people.PeopleResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.result.ResultResponse;
import com.javaChallenge.apiStartWars.dto.result.ResultDTO;
import com.javaChallenge.apiStartWars.service.Impl.PeopleServiceImpl;
import com.javaChallenge.apiStartWars.service.PeopleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PeopleServiceImplTest {

    @Autowired
    private PeopleService peopleService;

    @MockBean
    private StarwarsClient starwarsClient;

    @BeforeEach
    void setUp() {
        PeopleResponse mockPeopleResponse = new PeopleResponse();
        mockPeopleResponse.setMessage("ok");
        mockPeopleResponse.setTotalRecords(82);
        mockPeopleResponse.setTotalPages(9);
        mockPeopleResponse.setPrevious(null);
        mockPeopleResponse.setNext("https://www.swapi.tech/api/people?page=2&limit=10");
        mockPeopleResponse.setResults(Arrays.asList(
                new ResultResponse(1,"Luke Skywalker","https://www.swapi.tech/api/people/1"),
                new ResultResponse(2,"C-3PO","https://www.swapi.tech/api/people/2"),
                new ResultResponse(3, "R2-D2", "https://www.swapi.tech/api/people/3"),
                new ResultResponse(4, "Darth Vader", "https://www.swapi.tech/api/people/4"),
                new ResultResponse(5, "Leia Organa", "https://www.swapi.tech/api/people/5"),
                new ResultResponse(6, "Owen Lars", "https://www.swapi.tech/api/people/6"),
                new ResultResponse(7, "Beru Whitesun lars", "https://www.swapi.tech/api/people/7"),
                new ResultResponse(8, "R5-D4", "https://www.swapi.tech/api/people/8"),
                new ResultResponse(9, "Biggs Darklighter", "https://www.swapi.tech/api/people/9"),
                new ResultResponse(10, "Obi-Wan Kenobi", "https://www.swapi.tech/api/people/10")
        ));

        Mockito.when(starwarsClient.getAllResponsePeople())
                .thenReturn(mockPeopleResponse);
    }

    @Test
    public void getAllPeople(){
        Pageable pageable = PageRequest.of(0,10);

        Page<ResultDTO> listPrueba = peopleService.getAllPeople(pageable);

        assertNotNull(listPrueba);
        assertEquals(10, listPrueba.getContent().size());
        assertEquals("Luke Skywalker", listPrueba.getContent().get(0).getName());
        assertEquals("C-3PO", listPrueba.getContent().get(1).getName());

    }
}