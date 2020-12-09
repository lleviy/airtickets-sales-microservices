package com.airticketssales.salesservice.repository;

import com.airticketssales.salesservice.domain.CreditCardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardDetailsRepository extends JpaRepository<CreditCardDetails, Long> {
}
