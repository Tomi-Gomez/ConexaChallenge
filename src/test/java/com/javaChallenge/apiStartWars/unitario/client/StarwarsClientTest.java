package com.javaChallenge.apiStartWars.unitario.client;

import com.javaChallenge.apiStartWars.clients.StarWars.StarwarsClient;
import com.javaChallenge.apiStartWars.clients.StarWars.response.people.PeopleIdResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.people.PeopleProperties;
import com.javaChallenge.apiStartWars.clients.StarWars.response.people.ResultPeopleResponse;
import com.javaChallenge.apiStartWars.dto.people.PeoplePropertiesDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultPeopleDTO;
import com.javaChallenge.apiStartWars.service.Impl.PeopleServiceImpl;
import com.javaChallenge.apiStartWars.service.PeopleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StarwarsClientTest {

    @MockBean
    private StarwarsClient starwarsClient;

    private PeopleIdResponse mockedResponse;

    @BeforeEach
    void setUp() {
        PeopleProperties lukeProps = PeopleProperties.builder()
                .name("Luke Skywalker")
                .gender("male")
                .height("172")
                .mass("77")
                .build();

        ResultPeopleResponse resultPeople = new ResultPeopleResponse();
        resultPeople.setPeopleProperties(lukeProps);
        resultPeople.setId("5f63a36eee9fd7000499be42");
        resultPeople.setUid("1");
        resultPeople.setV(4);
        resultPeople.setDescription("A person within the Star Wars universe");

        mockedResponse = new PeopleIdResponse();
        mockedResponse.setMessage("ok");
        mockedResponse.setResult(resultPeople);
    }

    @Test
    public  void getIdResponsePeople(){
        Mockito.when(starwarsClient.getIdResponsePeople(1, "Luke Skywalker"))
                .thenReturn(mockedResponse);

        PeopleIdResponse response = starwarsClient.getIdResponsePeople(1, "Luke Skywalker");

        assertNotNull(response);
        assertEquals("ok", response.getMessage());

        ResultPeopleResponse result = response.getResult();
        assertNotNull(result);
        assertEquals("1", result.getUid());
        assertEquals("5f63a36eee9fd7000499be42", result.getId());
        assertEquals("A person within the Star Wars universe", result.getDescription());
        assertEquals(4, result.getV());

        PeopleProperties props = result.getPeopleProperties();
        assertNotNull(props);
        assertEquals("Luke Skywalker", props.getName());
        assertEquals("male", props.getGender());


        ResultPeopleDTO dto = ResultPeopleDTO.fromResultResponse(result);
        assertNotNull(dto);
        assertEquals("Luke Skywalker", dto.getPeoplePropertiesDTO().getName());


        Mockito.verify(starwarsClient, Mockito.times(1))
                .getIdResponsePeople(1, "Luke Skywalker");
    }
}