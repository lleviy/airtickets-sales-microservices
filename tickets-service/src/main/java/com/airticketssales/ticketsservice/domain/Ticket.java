package com.airticketssales.ticketsservice.domain;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double cost;

    @ManyToOne(fetch = FetchType.EAGER)
    private Flight flight;

    @ManyToOne(fetch = FetchType.EAGER)
    private Passenger passenger;

    @OneToOne
    private Seat seat;

    private TicketStatuses status;

    public Ticket() {
    }

    public Ticket(double cost, Flight flight, Passenger passenger, Seat seat, TicketStatuses status) {
        this.cost = cost;
        this.flight = flight;
        this.passenger = passenger;
        this.seat = seat;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public TicketStatuses getStatus() {
        return status;
    }

    public void setStatus(TicketStatuses status) {
        this.status = status;
    }
}
