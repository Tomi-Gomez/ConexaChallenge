package com.javaChallenge.apiStartWars.integral.controller;

import com.javaChallenge.apiStartWars.integral.client.StarWarsClientMockFailed;
import com.javaChallenge.apiStartWars.security.JwtUtil;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PeopleControllerTestFailed {


    private final StarWarsClientMockFailed starWarsClientMockFailed = new StarWarsClientMockFailed(8089);

    @Autowired
    private JwtUtil jwtUtil;

    @BeforeAll
    public void initialize() throws IOException {
        starWarsClientMockFailed.starWarsMockServerPeople();
    }

    @AfterAll
    public void finishMock(){
        starWarsClientMockFailed.stop();
    }

    @Test
    public void peopleControllerTestFailed() {
        String token = jwtUtil.generateToken("testuser", "USER");

        given()
                .accept(ContentType.JSON)
                .header(AUTHORIZATION, "Bearer " + token)
                .when()
                .get("/api/v1/people/")
                .then()
                .log().all()
                .statusCode(404)
                .body("error",equalTo("Error al consultar la api"));

    }
}
