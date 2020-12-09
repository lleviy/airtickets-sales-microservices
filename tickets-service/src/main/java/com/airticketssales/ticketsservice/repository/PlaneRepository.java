package com.airticketssales.ticketsservice.repository;

import com.airticketssales.ticketsservice.domain.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {
}
