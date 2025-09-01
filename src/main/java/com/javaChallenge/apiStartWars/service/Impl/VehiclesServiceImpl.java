package com.javaChallenge.apiStartWars.service.Impl;

import com.javaChallenge.apiStartWars.clients.StarWars.StarwarsClient;
import com.javaChallenge.apiStartWars.clients.StarWars.response.people.PeopleIdResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.vehicles.VehiclesIdResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.vehicles.VehiclesNameResponse;
import com.javaChallenge.apiStartWars.clients.StarWars.response.vehicles.VehiclesResponse;
import com.javaChallenge.apiStartWars.dto.people.PeopleIdDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultPeopleDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultVehiclesDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultVehiclesNameDTO;
import com.javaChallenge.apiStartWars.dto.vehicles.VehiclesDTO;
import com.javaChallenge.apiStartWars.dto.vehicles.VehiclesIdDTO;
import com.javaChallenge.apiStartWars.exception.StarwarsNotFoundException;
import com.javaChallenge.apiStartWars.service.VehiclesService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiclesServiceImpl implements VehiclesService {

    @Autowired
    private StarwarsClient starwarsClient;

    @Override
    public Page<ResultDTO> getAllVehicles(Pageable pageable) {
        VehiclesResponse vehiclesResponse;

        try {
            vehiclesResponse = starwarsClient.getAllResponseVehicles()
            ;
        } catch (FeignException.NotFound  e) {
            throw new StarwarsNotFoundException("Error al consultar la api");
        }

        return new VehiclesDTO(vehiclesResponse,pageable).getResults();
    }

    @Override
    public ResultVehiclesDTO getIdVehicles(int id, String name) {
        VehiclesIdResponse vehiclesIdResponse = starwarsClient.getIdResponseVehicles(id,name);
        return new VehiclesIdDTO(vehiclesIdResponse).getResultVehiclesDTO();
    }

    @Override
    public ResultVehiclesNameDTO getNameVehicles(String name) {
        VehiclesNameResponse vehiclesNameResponse = starwarsClient.getNameResponseVehicles(name);
        return new ResultVehiclesNameDTO(vehiclesNameResponse);
    }
}
