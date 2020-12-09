package com.airticketssales.ticketsservice.repository;


import com.airticketssales.ticketsservice.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
