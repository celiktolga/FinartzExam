package com.example.ticketsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FlightDto {

    private Long company_id;
    private Long route_id;
    private double price;
    private Integer soldSeat;
    private Integer quota;
}
