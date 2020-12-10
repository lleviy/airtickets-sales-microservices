package com.airticketssales.ticketsservice.controller;


import com.airticketssales.ticketsservice.domain.Ticket;
import com.airticketssales.ticketsservice.dto.OrderDto;
import com.airticketssales.ticketsservice.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tickets")
public class TicketsController {
    private TicketService ticketService;

    public TicketsController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> getAll() {
        List<Ticket> tickets = ticketService.getAll();
        return tickets;
    }

    @PostMapping
    public String buyTickets(@RequestBody OrderDto orderDto) {
        ticketService.buyTickets(orderDto);
        return "Заказ оформлен";
    }
}
