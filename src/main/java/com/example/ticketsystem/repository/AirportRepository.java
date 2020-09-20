package com.example.ticketsystem.repository;

import com.example.ticketsystem.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long>   {
}
