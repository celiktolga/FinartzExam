package com.example.ticketsystem.dto;

import com.example.ticketsystem.model.Airport;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AirportMapper {

    public AirportMapper() {

    }

    public static AirportDto toDto(Airport airport) {
        AirportDto airportDto = new AirportDto();
        airportDto.setAirport_id(airport.getId());
        airportDto.setName(airport.getName());
        return airportDto;
    }

    public static  Airport toModel(AirportDto airportDto) {
        Airport airport = new Airport();
        airport.setId(airportDto.getAirport_id());
        airport.setName(airportDto.getName());
        return airport;
    }
}
