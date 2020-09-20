package com.example.ticketsystem.controller;

import com.example.ticketsystem.dto.TicketDto;
import com.example.ticketsystem.model.Ticket;
import com.example.ticketsystem.serice.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/getAll")
    public List<Ticket> getAll() {
        return ticketService.getAll();
    }

    @PostMapping("/add")
    public void addTicket(@RequestBody TicketDto ticket) throws Exception {
        ticketService.addTicket(ticket);
    }

    @PostMapping("/update")
    public void updateTicket(@RequestBody TicketDto ticket) {
        ticketService.updateTicket(ticket);
    }
}
