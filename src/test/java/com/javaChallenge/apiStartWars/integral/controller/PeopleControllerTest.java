package com.javaChallenge.apiStartWars.integral.controller;

import com.javaChallenge.apiStartWars.integral.client.StarWarsClientMock;
import com.javaChallenge.apiStartWars.security.JwtUtil;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PeopleControllerTest {

    private final StarWarsClientMock starWarsClientMock = new StarWarsClientMock(8089);

    @Autowired
    private JwtUtil jwtUtil;

    @BeforeAll
    public void initialize() throws IOException {
        starWarsClientMock.starWarsMockServerPeople();
    }

    @Test
    public void validatePeopleJson() {
        String token = jwtUtil.generateToken("testuser", "USER");

        given()
                .accept(ContentType.JSON)
                .header(AUTHORIZATION, "Bearer " + token)
                .when()
                .get("/api/v1/people/")
                .then()
                .statusCode(200)
                .body("content", not(empty()))
                .body("content.uid", everyItem(notNullValue()))
                .body("content.name", everyItem(not(emptyString())))
                .body("content.url", everyItem(startsWith("https://")))
                .body("content.uid", everyItem(greaterThan(0)));
    }
}
