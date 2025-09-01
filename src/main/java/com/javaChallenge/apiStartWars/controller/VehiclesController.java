package com.javaChallenge.apiStartWars.controller;

import com.javaChallenge.apiStartWars.dto.result.ResultDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultVehiclesDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultVehiclesNameDTO;
import com.javaChallenge.apiStartWars.dto.vehicles.VehiclesIdDTO;
import com.javaChallenge.apiStartWars.service.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehiclesController {
    @Autowired
    private VehiclesService vehiclesService;

    @GetMapping("/")
    public ResponseEntity<Page<ResultDTO>> getAllVehicles(Pageable pageable){
        return new ResponseEntity<>(vehiclesService.getAllVehicles(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultVehiclesDTO> getIdVehicles(@PathVariable(value = "id",required = false) int id,
                                                           @RequestParam(value = "name",required = false)String name){
        return new ResponseEntity<>(vehiclesService.getIdVehicles(id,name),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<ResultVehiclesNameDTO> getNameVehicles(@RequestParam(value = "name")String name){
        return new ResponseEntity<>(vehiclesService.getNameVehicles(name),HttpStatus.OK);
    }


}
