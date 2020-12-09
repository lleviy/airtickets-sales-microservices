package com.airticketssales.ticketsservice.service;

import com.airticketssales.ticketsservice.domain.Passenger;
import com.airticketssales.ticketsservice.domain.Ticket;
import com.airticketssales.ticketsservice.domain.TicketStatuses;
import com.airticketssales.ticketsservice.dto.OrderDto;
import com.airticketssales.ticketsservice.dto.TicketPurchaseDto;
import com.airticketssales.ticketsservice.event.source.SourceBean;
import com.airticketssales.ticketsservice.repository.PassengerRepository;
import com.airticketssales.ticketsservice.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{
    private final TicketRepository ticketRepository;
    private PassengerRepository passengerRepository;

    private SourceBean sourceBean;

    public TicketServiceImpl(TicketRepository ticketRepository, PassengerRepository passengerRepository, SourceBean sourceBean) {
        this.ticketRepository = ticketRepository;
        this.passengerRepository = passengerRepository;
        this.sourceBean = sourceBean;
    }

    @Override
    public List<Ticket> getAll() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets;
    }

    @Override
    public void updateTicket(Ticket ticket) {
        ticket = ticketRepository.save(ticket);
    }

    @Override
    public void buyTickets(OrderDto orderDto) {
        Double cost = (double) 0;
        List<Long> ticketsIds = new ArrayList<>();
        for (TicketPurchaseDto ticketDto : orderDto.getTickets()){
            Ticket ticket = ticketRepository.findById(ticketDto.getTicketId()).get();
            cost += ticket.getCost();
            ticketsIds.add(ticket.getId());
            Passenger passenger = new Passenger(ticketDto.getPassengerName(), ticketDto.getPassengerBirthDate(),
                    ticketDto.getPassengerDocumentNo());
            ticket.setPassenger(passenger);
            ticket.setStatus(TicketStatuses.BOUGHT);
            passengerRepository.save(passenger);
            ticketRepository.save(ticket);
        }
        sourceBean.sendTicketOrder(ticketsIds, orderDto.getCustomerName(), orderDto.getCardNo(), cost);
    }

    public void confirmTicketsPurchase(){

    }
}
