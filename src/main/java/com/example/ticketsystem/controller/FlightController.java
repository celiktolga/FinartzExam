package com.example.ticketsystem.controller;

import com.example.ticketsystem.dto.FlightDto;
import com.example.ticketsystem.serice.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/getAll")
    public List<FlightDto> getAll() {
        return flightService.getAll();
    }

    @PostMapping("/add")
    public void addFlight(@RequestBody List<FlightDto> flight) {
        flightService.addFlight(flight);
    }


}
