package com.javaChallenge.apiStartWars.unitario.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.javaChallenge.apiStartWars.controller.PeopleController;
import com.javaChallenge.apiStartWars.dto.people.PeoplePropertiesDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultPeopleDTO;
import com.javaChallenge.apiStartWars.security.JwtUtil;
import com.javaChallenge.apiStartWars.security.UserDetailService;
import com.javaChallenge.apiStartWars.service.PeopleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(PeopleController.class)
class PeopleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PeopleService peopleService;

    @MockBean
    private JwtUtil jwtUtil;

    @MockBean
    private UserDetailService userDetailsService;

    ResultPeopleDTO resultPeopleDTO;

    @BeforeEach
    void setUp() {
        PeoplePropertiesDTO LukeSkywalker = PeoplePropertiesDTO.builder()
                .created("2025-08-31T18:29:44.860Z")
                .edited("2025-08-31T18:29:44.860Z")
                .name("Luke Skywalker")
                .gender("male")
                .height("172")
                .mass("77")
                .homeworld("https://www.swapi.tech/api/planets/1")
                .vehicles(Arrays.asList(
                        "https://www.swapi.tech/api/vehicles/14",
                        "https://www.swapi.tech/api/vehicles/30"))
                .starships(Arrays.asList(
                        "https://www.swapi.tech/api/starships/12",
                        "https://www.swapi.tech/api/starships/22"))
                .films(Arrays.asList(
                        "https://www.swapi.tech/api/films/1",
                        "https://www.swapi.tech/api/films/2",
                        "https://www.swapi.tech/api/films/3",
                        "https://www.swapi.tech/api/films/6"))
                .url("https://www.swapi.tech/api/people/1")
                .skinColor("fair")
                .hairColor("blond")
                .eyeColor("blue")
                .birthYear("19BBY")
                .build();


       resultPeopleDTO = ResultPeopleDTO.builder()
                .id("5f63a36eee9fd7000499be42")
                .uid("1")
                .v(4)
                .description("A person within the Star Wars universe")
                .peoplePropertiesDTO(LukeSkywalker)
                .build();
    }


    @Test
    public void getIdPeopleTest() throws Exception {

        String token = jwtUtil.generateToken("conexa1", "USER");

        Mockito.when(peopleService.getIdPeople(1,"Luke Skywalker")).thenReturn(resultPeopleDTO);

        mockMvc.perform(get("/api/v1/people/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("name", "Luke Skywalker")
                        .header("Authorization", "Bearer " + token))

                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.uid").value("1"))
                .andExpect(jsonPath("$.properties.name").value("Luke Skywalker"));

    }

}