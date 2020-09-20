package com.example.ticketsystem.serice;

import com.example.ticketsystem.dto.AirportDto;
import com.example.ticketsystem.dto.AirportMapper;
import com.example.ticketsystem.model.Airport;
import com.example.ticketsystem.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportService {
    @Autowired
    AirportRepository airportRepository;

    public List<AirportDto> getAll() {
        List<Airport> airports = airportRepository.findAll();
        return airports.stream().map(AirportMapper::toDto).collect(Collectors.toList());

    }

    public void addAirport(List<AirportDto> airport) {
        airportRepository.saveAll(airport.stream().map(AirportMapper::toModel).collect(Collectors.toList()));
    }

    public  Airport findById(Long id){
        return airportRepository.getOne(id);
    }
}
