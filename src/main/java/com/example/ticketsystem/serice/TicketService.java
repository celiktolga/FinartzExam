package com.example.ticketsystem.serice;

import com.example.ticketsystem.dto.TicketDto;
import com.example.ticketsystem.dto.TicketMapper;
import com.example.ticketsystem.model.Flight;
import com.example.ticketsystem.model.Ticket;
import com.example.ticketsystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    FlightService flightService;

    public List<Ticket> getAll() {
        return ticketRepository.findAll();
        //return tickets.stream().map(TicketMapper::toDto).collect(Collectors.toList());
    }

    public void updateTicket(TicketDto ticketDto) {

        Ticket ticket = TicketMapper.toModel(ticketDto);
        ticket.setId(ticketDto.getFlight_id());
        Long id = ticketDto.getFlight_id();
        Optional<Flight> flight = flightService.findById(id);
        ticket.setFlight(flight.get());
        ticketRepository.save(ticket);
    }

    public void addTicket(TicketDto ticketDto) throws Exception {

        Ticket ticket = TicketMapper.toModel(ticketDto);
        Long id = ticketDto.getFlight_id();
        Optional<Flight> flight = flightService.findById(id);
        ticket.setFlight(flight.get());


        if (ticket.getFlight().getSoldSeat() == null) {
            ticket.getFlight().setSoldSeat(1);
        } else {
            ticket.getFlight().setSoldSeat(ticket.getFlight().getSoldSeat() + 1);
        }

        ticketDto.setCreditCard(maskCCNumber(convertDigit(ticketDto.getCreditCard()))); // masked

        int maxSeat = ticket.getFlight().getQuota();
        int soldSeat = ticket.getFlight().getSoldSeat();
        int perc = 10;// %10

        if (maxSeat < soldSeat) {
            throw new Exception("MAXIMUM SEAT SOLD");
        }
        flightService.save(ticket.getFlight());

        int total = calculateIncreament(soldSeat, maxSeat, perc);
        ticket.setCost(total * 0.1 * ticket.getFlight().getPrice() + ticket.getFlight().getPrice());

        flightService.save(ticket.getFlight());
        ticketRepository.save(ticket);
    }

    private Integer calculateIncreament(Integer soldSeat, Integer totalSeat, Integer perc) {

        int mod = calculateMod(totalSeat, perc);


        int increaseCount = 0;
        increaseCount = soldSeat / mod;
        /*
        for (int i = 1; i <= soldSeat; i++) {
            if (soldSeat > i * mod) {
                increaseCount++;
            }
        }*/
        return increaseCount;
    }

    private Integer calculateMod(Integer totalSeat, Integer perc) {
        if (totalSeat % perc != 0) {
            return totalSeat % perc;
        } else {
            return totalSeat / perc;
        }
    }

    private String maskCCNumber(String ccnum) {
        int total = ccnum.length();
        int startlen = 6, endlen = 4;
        int masklen = total - (startlen + endlen);
        StringBuffer maskedbuf = new StringBuffer(ccnum.substring(0, startlen));
        for (int i = 0; i < masklen; i++) {
            maskedbuf.append('X');
        }
        maskedbuf.append(ccnum.substring(startlen + masklen, total));
        return maskedbuf.toString();
    }

    private String convertDigit(String value) {
        StringBuffer sBuffer = new StringBuffer();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(value);
        while (matcher.find()) {
            sBuffer.append(matcher.group());
        }
        return sBuffer.toString();
    }

}
