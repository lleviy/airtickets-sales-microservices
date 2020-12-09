package com.airticketssales.ticketsservice.repository;


import com.airticketssales.ticketsservice.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
}
