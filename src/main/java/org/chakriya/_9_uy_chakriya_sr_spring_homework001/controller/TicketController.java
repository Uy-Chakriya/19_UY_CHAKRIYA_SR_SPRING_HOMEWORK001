package org.chakriya._9_uy_chakriya_sr_spring_homework001.controller;
import org.chakriya._9_uy_chakriya_sr_spring_homework001.Status.TicketStatus;
import org.chakriya._9_uy_chakriya_sr_spring_homework001.model.ApiResponse;
import org.chakriya._9_uy_chakriya_sr_spring_homework001.model.Ticket;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")

public class TicketController {
public final List<Ticket> TICKET_LIST = new ArrayList<>();

    public TicketController(){
        int ticketId = 1;
        TICKET_LIST.add(new Ticket(ticketId++, "Chakriya", LocalDate.of(2026,11,3), "PP", "Kompot", 1000.0, "Paid", "Booked", 1));
        TICKET_LIST.add(new Ticket(ticketId++, "Chakriya", LocalDate.of(2026,11,3), "PP", "Kompot", 1000.0, "Paid", "Booked", 1));
        TICKET_LIST.add(new Ticket(ticketId++, "Chakriya", LocalDate.of(2026,11,3), "PP", "Kompot", 1000.0, "Paid", "Booked", 1));
        TICKET_LIST.add(new Ticket(ticketId++, "Chakriya", LocalDate.of(2026,11,3), "PP", "Kompot", 1000.0, "Paid", "Booked", 1));


    }

    @PostMapping()
    public Ticket addTdicket(@RequestBody Ticket ticket){
        TICKET_LIST.add(ticket);
        return ticket;
    }


    @PostMapping("/bulk")
    public List<Ticket> addTickets(@RequestBody List<List<Ticket>> tickets){
        TICKET_LIST.addAll(tickets.get(0));
        return tickets.get(0);
    }

    @GetMapping()
      public ApiResponse<List<Ticket>> getAllTickets(){
        return new ApiResponse<>(
                "true",
                "All tickets retrieved",
                "200 OK",
                TICKET_LIST,
                LocalDateTime.now()
        );
    }


    @GetMapping("/{ticket-id}")
    public Ticket getTicketById( @PathVariable("ticket-id") Integer id){
        for(Ticket ticket : TICKET_LIST){
            if(ticket.getTicketId().equals(id)){
                return ticket;
            }
        }
        return null;
    }

    @PutMapping("/{ticket-id}")
    public Ticket updateTicket(@PathVariable("ticket-id") Integer id, @RequestBody Ticket ticket)
    {
        for (Ticket nTicket : TICKET_LIST)
        {
            if (nTicket.getTicketId().equals(id)) {
                nTicket.setPassengerName(ticket.getPassengerName());
                nTicket.setTravelDate(ticket.getTravelDate());
                nTicket.setSourceStation(ticket.getSourceStation());
                nTicket.setDestinationStation(ticket.getDestinationStation());
                nTicket.setPrice(ticket.getPrice());
                nTicket.setPaymentStatus(ticket.getPaymentStatus());
                nTicket.setTicketStatus(ticket.getTicketStatus());
                nTicket.setSeatNumber(ticket.getSeatNumber());
                return nTicket;
            }
        }
        return null;
    }

    @DeleteMapping("/{ticket-id}")
    public void deleteTicket(@PathVariable("ticket-id") Integer id){
        TICKET_LIST.removeIf(ticket -> ticket.getTicketId().equals(id) );
    }

    @GetMapping("/search")
    public List<Ticket> searchTicket(String passengerName){
        List<Ticket> ticketList = new ArrayList<>();
        for(Ticket ticket : TICKET_LIST){
            if(ticket.getPassengerName().equals(passengerName)){
                ticketList.add(ticket);
            }
        }
        return ticketList;
    }


    @GetMapping("/filter")
    public List<Ticket> filterTicket(TicketStatus ticketStatus, int travelDate){
        List<Ticket> ticketList = new ArrayList<>();
        for(Ticket ticket : TICKET_LIST){
            if(ticket.getTicketStatus().equals(ticketStatus) && ticket.getTravelDate().equals(travelDate)){
                ticketList.add(ticket);
            }
        }
        return ticketList;
    }
}
