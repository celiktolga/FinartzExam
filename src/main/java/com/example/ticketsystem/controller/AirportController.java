package com.example.ticketsystem.controller;

import com.example.ticketsystem.dto.AirportDto;
import com.example.ticketsystem.model.Airport;
import com.example.ticketsystem.serice.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/getAll")
    public List<AirportDto> getAll() {
        return airportService.getAll();
    }

    @PostMapping("/add")
    public void addAirport(@RequestBody List<AirportDto> airportDtos) {
        airportService.addAirport(airportDtos);
    }

    @GetMapping("/getById/{companyId}")
    public Airport getById(Long id) {//or @PathVariable Long companyId
        return airportService.findById(id);
    }
}
