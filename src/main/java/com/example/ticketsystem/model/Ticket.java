package com.example.ticketsystem.model;

import com.example.ticketsystem.utils.TicketStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Ticket extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
    private Double cost;
    private String creditCard;

}
