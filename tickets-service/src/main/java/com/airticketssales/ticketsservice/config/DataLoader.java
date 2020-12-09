package com.airticketssales.ticketsservice.config;

import com.airticketssales.ticketsservice.domain.Flight;
import com.airticketssales.ticketsservice.domain.Plane;
import com.airticketssales.ticketsservice.domain.Seat;
import com.airticketssales.ticketsservice.domain.Ticket;
import com.airticketssales.ticketsservice.repository.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
public class DataLoader implements ApplicationRunner {

    private final FlightRepository flightRepository;
    private final PlaneRepository planeRepository;
    private final TicketRepository ticketRepository;
    private final PassengerRepository passengerRepository;
    private final SeatRepository seatRepository;

    public DataLoader(FlightRepository flightRepository, PlaneRepository planeRepository, TicketRepository ticketRepository, PassengerRepository passengerRepository, SeatRepository seatRepository) {
        this.flightRepository = flightRepository;
        this.planeRepository = planeRepository;
        this.ticketRepository = ticketRepository;
        this.passengerRepository = passengerRepository;
        this.seatRepository = seatRepository;
    }

    @Transactional
    public void run(ApplicationArguments args) {
        Plane plane = new Plane("SU-27");
        planeRepository.save(plane);

        Seat seat = new Seat(planeRepository.findById((long) 1).get(), "1");
        Seat seat2 = new Seat(planeRepository.findById((long) 1).get(), "2");
        seatRepository.save(seat);
        seatRepository.save(seat2);

        Plane planeRepositoryOne = planeRepository.findById((long) 1).get();
        Flight flight = new Flight(planeRepositoryOne, LocalDateTime.of(2020, 11, 28, 23, 23),
                LocalDateTime.of(2020, 11, 29, 23, 23),
                "Pulkovo", "Domodedovo");
        flightRepository.save(flight);
        flightRepository.findAll();

        Flight flightRepositoryOne = flightRepository.findById((long) 1).get();
        Seat seatRepositoryOne = seatRepository.findById((long) 1).get();
        Seat seatRepositoryOne1 = seatRepository.findById((long) 2).get();
        Ticket ticket = new Ticket(3458.4, flightRepositoryOne, null, seatRepositoryOne, null);
        Ticket ticket2 = new Ticket(3458.4, flightRepositoryOne, null, seatRepositoryOne1, null);

        ticketRepository.save(ticket);
        ticketRepository.save(ticket2);
    }
}
