package com.example.ticketsystem.serice;

import com.example.ticketsystem.dto.FlightDto;
import com.example.ticketsystem.dto.FlightMapper;
import com.example.ticketsystem.model.Flight;
import com.example.ticketsystem.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    CompanyService companyService;

    @Autowired
    RouteService routeService;

    public List<FlightDto> getAll() {
        List<Flight> flights = flightRepository.findAll();
        return flights.stream().map(FlightMapper::toDto).collect(Collectors.toList());
    }

    public void addFlight(List<FlightDto> flightDtos) {

        List<Flight> flightList = new ArrayList<>();
        flightDtos.stream().forEach(flightDto -> {
            Flight flight = FlightMapper.toModel(flightDto);
            flight.setRoute(routeService.findById(flightDto.getRoute_id()));
            flight.setCompany(companyService.getById(flightDto.getCompany_id()));
            flightList.add(flight);
        });

        flightRepository.saveAll(flightList);
    }

    public Optional<Flight> findById(Long id) {
        return flightRepository.findById(id);
    }

    public void save(Flight flight){
        flightRepository.save(flight);
    }
}
