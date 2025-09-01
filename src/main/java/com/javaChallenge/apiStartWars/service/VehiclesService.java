package com.javaChallenge.apiStartWars.service;

import com.javaChallenge.apiStartWars.dto.result.ResultDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultVehiclesDTO;
import com.javaChallenge.apiStartWars.dto.result.ResultVehiclesNameDTO;
import com.javaChallenge.apiStartWars.dto.vehicles.VehiclesIdDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VehiclesService {
    public Page<ResultDTO> getAllVehicles(Pageable pageable);

    public ResultVehiclesDTO getIdVehicles(int id, String name);

    public ResultVehiclesNameDTO getNameVehicles(String name);
}
