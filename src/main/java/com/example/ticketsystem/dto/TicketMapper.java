package com.example.ticketsystem.dto;

import com.example.ticketsystem.model.Ticket;

public class TicketMapper {

    public TicketMapper() {

    }

    public static TicketDto toDto(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        //ticketDto.setTicket_id(ticket.getId());
        ticketDto.setCost(ticket.getCost());
        ticketDto.setCreditCard(ticket.getCreditCard());
        ticketDto.setFlight_id(ticket.getFlight().getId());
        ticketDto.setTicketStatus(ticket.getTicketStatus());
        return ticketDto;
    }

    public static Ticket toModel(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        //ticket.setId(ticketDto.getFlight_id());
        ticket.setCost(ticketDto.getCost());
        ticket.setCreditCard(ticketDto.getCreditCard());

        ticket.setTicketStatus(ticketDto.getTicketStatus());
        return ticket;
    }

}
