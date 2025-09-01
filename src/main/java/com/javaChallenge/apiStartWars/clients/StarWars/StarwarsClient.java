package com.javaChallenge.apiStartWars.clients.StarWars;

import com.javaChallenge.apiStartWars.clients.StarWars.response.film.FilmIdResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.film.FilmNameResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.vehicles.VehiclesNameResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.film.FilmResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.people.PeopleIdResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.people.PeopleNameResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.starships.StarshipsIdResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.starships.StarshipsNameResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.starships.StarshipsResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.people.PeopleResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.vehicles.VehiclesIdResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.vehicles.VehiclesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "starwars",url = "${starWars.client}")
public interface StarwarsClient {
    @GetMapping("/api/people/")
    public PeopleResponse getAllResponsePeople();

    @GetMapping("/api/people/{id}")
    public PeopleIdResponse getIdResponsePeople(@PathVariable(value = "id") int id,
                                                @RequestParam(value = "name", required = false) String name);

    @GetMapping("/api/people")
    public PeopleNameResponse getNameResponsePeople(@RequestParam(value = "name", required = false) String name);

    @GetMapping("/api/starships/")
    public StarshipsResponse getAllResponseStarships();

    @GetMapping("/api/starships/{id}")
    public StarshipsIdResponse getIdResponseStarships(@PathVariable(value = "id") int id,
                                                      @RequestParam(value = "name", required = false) String name);

    @GetMapping("/api/starships")
    public StarshipsNameResponse getNameResponseStarship(@RequestParam(value = "name", required = false) String name);


    @GetMapping("/api/vehicles/")
    public VehiclesResponse getAllResponseVehicles();

    @GetMapping("/api/vehicles/{id}")
    public VehiclesIdResponse getIdResponseVehicles(@PathVariable(value = "id") int id,
                                                     @RequestParam(value = "name", required = false) String name);

    @GetMapping("/api/vehicles")
    public VehiclesNameResponse getNameResponseVehicles(@RequestParam(value = "name", required = false) String name);

    @GetMapping("/api/films/")
    public FilmResponse getAllResponseFilms();

    @GetMapping("/api/films/{id}")
    public FilmIdResponse getIdResponseFilm(@PathVariable(value = "id") int id,
                                            @RequestParam(value = "title", required = false) String title);

    @GetMapping("/api/films")
    public FilmNameResponse getNameResponseFilm(@RequestParam(value = "title", required = false) String tile);
}
