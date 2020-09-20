package com.example.ticketsystem.dto;

import com.example.ticketsystem.utils.TicketStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
public class TicketDto {

    private Long ticket_id;
    private Long flight_id;
    private TicketStatus ticketStatus;
    private Double cost;
    private String creditCard;

}
