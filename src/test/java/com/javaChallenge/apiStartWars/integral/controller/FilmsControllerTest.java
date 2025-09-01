package com.javaChallenge.apiStartWars.integral.controller;

import com.javaChallenge.apiStartWars.integral.client.StarWarsClientMock;
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
public class FilmsControllerTest {

    private final StarWarsClientMock starWarsClientMock = new StarWarsClientMock(8089);

    @Autowired
    private JwtUtil jwtUtil;

    @BeforeAll
    public void initialize() throws IOException {
        starWarsClientMock.starWarsMockServerFilms();
    }
    @AfterAll
    public void finishMock(){
        starWarsClientMock.stop();
    }

    @Test
    public void filmControllerTestOk() {
        String token = jwtUtil.generateToken("testuser", "USER");

        given()
                .accept(ContentType.JSON)
                .header(AUTHORIZATION, "Bearer " + token)
                .when()
                .get("/api/v1/films/")
                .then()
                .statusCode(200)
                .body("content", not(empty()))
                .body("content.uid", everyItem(not(emptyString())))
                .body("content.title", everyItem(not(emptyString())))
                .body("content.url", everyItem(startsWith("https://")))
                .body("content.properties.title", everyItem(not(emptyString())))
                .body("content.properties.episode_id", everyItem(greaterThan(0)))
                .body("content.properties.director", everyItem(not(emptyString())))
                .body("content.properties.producer", everyItem(not(emptyString())))
                .body("content.properties.release_date", everyItem(not(emptyString())))
                .body("content.properties.opening_crawl", everyItem(not(emptyString())))
                .body("content.properties.characters", everyItem(not(empty())))
                .body("content.properties.starships", everyItem(not(empty())))
                .body("content.properties.vehicles", everyItem(not(empty())))
                .body("content.properties.planets", everyItem(not(empty())))
                .body("content.properties.species", everyItem(not(empty())))
                .body("content.properties.created", everyItem(not(emptyString())))
                .body("content.properties.edited", everyItem(not(emptyString())));
    }

}
