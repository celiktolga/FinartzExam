package com.example.ticketsystem.dto;


import com.example.ticketsystem.model.Route;

public class RouteMapper {
    public RouteMapper() {

    }

    public static RouteDto toDto(Route route) {
        RouteDto dto = new RouteDto();
        dto.setRoute_id(route.getId());
        dto.setDestination_id(route.getDestinationAirport().getId());
        dto.setOrigin_id(route.getOriginAirport().getId());
        return dto;
    }

}
