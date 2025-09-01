package com.javaChallenge.apiStartWars.unitario.resultDTO;

import java.util.Arrays;

import com.javaChallenge.apiStartWars.clients.StarWars.response.film.FilmNameResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.film.FilmProperties;
import com.javaChallenge.apiStartWars.clients.StarWars.response.film.ResultFilmResponse;
import com.javaChallenge.apiStartWars.dto.result.ResultFilmDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultFilmNameDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultFilmNameDTOTest {

    @Test
    void testConstructorWithFilmResponse(){

        ResultFilmResponse film1 = new ResultFilmResponse();
        film1.setUid("1");
        film1.setProperties(new FilmProperties(
                "2025-08-28T16:42:09.672Z",
                "2025-08-28T16:42:09.672Z",
                Arrays.asList("https://swapi.dev/api/starships/12/", "https://swapi.dev/api/starships/14/"),
                Arrays.asList("https://swapi.dev/api/vehicles/33/"),
                Arrays.asList("https://swapi.dev/api/planets/7/"),
                "Gary Kurtz, Rick McCallum",
                "A New Hope",
                4,
                "George Lucas",
                "1977-05-25",
                "It is a period of civil war.\\r\\nRebel spaceships, striking\\r\\nfrom a hidden base, " +
                        "have won\\r\\ntheir first victory against\\r\\nthe evil Galactic Empire.\\r\\n\\r\\nDuring the " +
                        "battle, Rebel\\r\\nspies managed to steal secret\\r\\nplans to the Empire's\\r\\nultimate" +
                        " weapon, the DEATH\\r\\nSTAR, an armored space\\r\\nstation with enough power\\r\\nto destroy" +
                        " an entire planet.\\r\\n\\r\\nPursued by the Empire's\\r\\nsinister agents, Princess\\r\\nLeia" +
                        " races home aboard her\\r\\nstarship, custodian of the\\r\\nstolen plans that can save " +
                        "her\\r\\npeople and restore\\r\\nfreedom to the galaxy....",
                Arrays.asList("\"https://www.swapi.tech/api/people/1\",\n" +
                        "                    \"https://www.swapi.tech/api/people/2\",\n" +
                        "                    \"https://www.swapi.tech/api/people/3\""),
                Arrays.asList("\"https://www.swapi.tech/api/species/1\",\n" +
                        "                    \"https://www.swapi.tech/api/species/2\""),
                "https://www.swapi.tech/api/films/1"
                ));

        ResultFilmResponse film2 = new ResultFilmResponse();
        film2.setUid("2");
        film2.setProperties(new FilmProperties(
                "2025-08-28T16:42:09.672Z",
                "2025-08-28T16:42:09.672Z",
                Arrays.asList("https://www.swapi.tech/api/starships/3","https://www.swapi.tech/api/starships/10"),
                Arrays.asList("https://www.swapi.tech/api/vehicles/8","https://www.swapi.tech/api/vehicles/14"),
                Arrays.asList("https://www.swapi.tech/api/planets/4","https://www.swapi.tech/api/planets/5"),
                "Gary Kurtz, Rick McCallum",
                "The Empire Strikes Back",
                5,
                "Irvin Kershner",
                "1980-05-17",
                "It is a dark time for the\r\nRebellion. Although the Death\r\nStar has been " +
                        "destroyed,\r\nImperial troops have driven the\r\nRebel forces from their hidden\r\nbase " +
                        "and pursued them across\r\nthe galaxy.\r\n\r\nEvading the dreaded Imperial\r\nStarfleet," +
                        " a group of freedom\r\nfighters led by Luke Skywalker\r\nhas established a new " +
                        "secret\r\nbase on the remote ice world\r\nof Hoth.\r\n\r\nThe evil lord Darth Vader," +
                        "\r\nobsessed with finding young\r\nSkywalker, has dispatched\r\nthousands of remote " +
                        "probes into\r\nthe far reaches of space....",
                Arrays.asList("https://www.swapi.tech/api/species/1",
                        "https://www.swapi.tech/api/species/2",
                        "https://www.swapi.tech/api/species/3"),
                Arrays.asList("https://www.swapi.tech/api/species/1",
                        "https://www.swapi.tech/api/species/2"),
                "https://www.swapi.tech/api/films/2"
        ));

        FilmNameResponse filmNameResponse = new FilmNameResponse();
        filmNameResponse.setResultFilmResponses(Arrays.asList(film1,film2));

        ResultFilmNameDTO resultFilmNameDTO = new ResultFilmNameDTO(filmNameResponse);

        assertNotNull(resultFilmNameDTO);
        assertEquals(2,resultFilmNameDTO.getResultFilmDTOS().size());

        ResultFilmDTO dto1 = resultFilmNameDTO.getResultFilmDTOS().get(0);
        assertEquals("1",dto1.getUid());
        assertEquals("A New Hope",dto1.getTitle());

        ResultFilmDTO dto2 = resultFilmNameDTO.getResultFilmDTOS().get(1);
        assertEquals("2",dto2.getUid());
        assertEquals("The Empire Strikes Back",dto2.getTitle());

    }
}