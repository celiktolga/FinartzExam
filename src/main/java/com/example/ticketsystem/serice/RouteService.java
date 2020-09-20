package com.example.ticketsystem.serice;

import com.example.ticketsystem.dto.RouteDto;
import com.example.ticketsystem.model.Airport;
import com.example.ticketsystem.model.Route;
import com.example.ticketsystem.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteService {


    @Autowired
    RouteRepository routeRepository;

    @Autowired
    AirportService airportService;

    public List<Route> getAll() {
        return routeRepository.findAll();
        //return routes.stream().map(RouteMapper::toDto).collect(Collectors.toList());
    }

    public void addRoute(List<RouteDto> routeList) {
        List<Route> modelList = new ArrayList<>();
        for (RouteDto dto : routeList) {
            Route route = new Route();
            Airport originAiport = airportService.findById(dto.getOrigin_id());
            Airport destinationAiport = airportService.findById(dto.getDestination_id());
            route.setDestinationAirport(destinationAiport);
            route.setOriginAirport(originAiport);
            modelList.add(route);
        }
        routeRepository.saveAll(modelList);
    }

    public Route findById(Long id) {
        return routeRepository.getOne(id);
    }
}


