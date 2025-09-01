package com.javaChallenge.apiStartWars.integral.client;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

public class StarWarsClientMockFailed extends WireMockServer {

    public StarWarsClientMockFailed(final int port){
        super(port);
    }


    public void starWarsMockServerPeople() throws IOException {
        this.start();

        this.stubFor(
                WireMock.get(WireMock.urlPathMatching("/api/people/"))
                        .willReturn(
                                WireMock.aResponse()
                                        .withStatus(HttpStatus.NOT_FOUND.value())
                                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        )
        );

    }

    public void starWarsMockServerVehicle() throws IOException {
        this.start();

        this.stubFor(
                WireMock.get(WireMock.urlPathMatching("/api/vehicle/"))
                        .willReturn(
                                WireMock.aResponse()
                                        .withStatus(HttpStatus.NOT_FOUND.value())
                                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        )
        );

    }

    public void starWarsMockServerStarships() throws IOException {
        this.start();

        this.stubFor(
                WireMock.get(WireMock.urlPathMatching("/api/starships/"))
                        .willReturn(
                                WireMock.aResponse()
                                        .withStatus(HttpStatus.NOT_FOUND.value())
                                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        )
        );

    }

    public void starWarsMockServerFilms() throws IOException {
        this.start();

        this.stubFor(
                WireMock.get(WireMock.urlPathMatching("/api/films/"))
                        .willReturn(
                                WireMock.aResponse()
                                        .withStatus(HttpStatus.NOT_FOUND.value())
                                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        )
        );

    }
}
