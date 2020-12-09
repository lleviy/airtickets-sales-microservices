package com.airticketssales.ticketsservice.service;

import com.airticketssales.ticketsservice.domain.Ticket;
import com.airticketssales.ticketsservice.dto.OrderDto;
import com.airticketssales.ticketsservice.dto.TicketPurchaseDto;

import java.util.List;

public interface TicketService {
    List<Ticket> getAll();
    void updateTicket(Ticket ticket);

    void buyTickets(OrderDto orderDto);
}
