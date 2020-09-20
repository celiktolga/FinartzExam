package com.example.ticketsystem.dto;

import com.example.ticketsystem.model.Flight;

public class FlightMapper {

    public FlightMapper() {

    }

    public static FlightDto toDto(Flight flight) {
        FlightDto flightDto = new FlightDto();
        flightDto.setCompany_id(flight.getCompany().getId());
        flightDto.setPrice(flight.getPrice());
        flightDto.setQuota(flight.getQuota());
        flightDto.setRoute_id(flight.getRoute().getId());
        flightDto.setSoldSeat(flight.getSoldSeat());
        return flightDto;
    }

    public static Flight toModel(FlightDto flightDto) {
        Flight flight = new Flight();
        flight.setPrice(flightDto.getPrice());
        flight.setQuota(flightDto.getQuota());
        flight.setSoldSeat(flightDto.getSoldSeat());
        return flight;
    }
}
