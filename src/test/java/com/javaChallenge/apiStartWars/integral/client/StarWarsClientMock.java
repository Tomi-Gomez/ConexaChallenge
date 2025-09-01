package com.javaChallenge.apiStartWars.integral.client;


import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class StarWarsClientMock extends WireMockServer {

    public StarWarsClientMock (final int port){
        super(port);
    }

    public void starWarsMockServerPeople() throws IOException {
        this.start();
        final File resource = new ClassPathResource("mock/starWarsResponsePeopleOk.json").getFile();
        final String starWarsPeopleClient = new String(Files.readAllBytes(resource.toPath()));

        this.stubFor(
                WireMock.post(WireMock.urlPathMatching("/api/people/"))
                        .willReturn(
                                WireMock.aResponse()
                                        .withStatus(HttpStatus.OK.value())
                                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                        .withBody(starWarsPeopleClient)
                        )
        );

    }

    public void starWarsMockServerStarship() throws IOException {
        this.start();
        final File resource = new ClassPathResource("mock/starWarsResponseStarshipsOk.json").getFile();
        final String starWarsPeopleClient = new String(Files.readAllBytes(resource.toPath()));

        this.stubFor(
                WireMock.post(WireMock.urlPathMatching("/api/starships"))
                        .willReturn(
                                WireMock.aResponse()
                                        .withStatus(HttpStatus.OK.value())
                                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                        .withBody(starWarsPeopleClient)
                        )
        );

    }

    public void starWarsMockServerVehicles() throws IOException {
        this.start();
        final File resource = new ClassPathResource("mock/startWarsResponseVehiclesOk.json").getFile();
        final String starWarsPeopleClient = new String(Files.readAllBytes(resource.toPath()));

        this.stubFor(
                WireMock.post(WireMock.urlPathMatching("/api/vehicles"))
                        .willReturn(
                                WireMock.aResponse()
                                        .withStatus(HttpStatus.OK.value())
                                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                        .withBody(starWarsPeopleClient)
                        )
        );
    }

    public void starWarsMockServerFilms() throws IOException {
        this.start();
        final File resource = new ClassPathResource("mock/starWarsResponseFilmsOk.json").getFile();
        final String starWarsPeopleClient = new String(Files.readAllBytes(resource.toPath()));

        this.stubFor(
                WireMock.post(WireMock.urlPathMatching("/api/films"))
                        .willReturn(
                                WireMock.aResponse()
                                        .withStatus(HttpStatus.OK.value())
                                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                        .withBody(starWarsPeopleClient)
                        )
        );
    }
}
