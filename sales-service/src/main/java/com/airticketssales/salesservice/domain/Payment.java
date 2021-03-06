package com.airticketssales.salesservice.domain;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private CreditCardDetails customer;

    @ElementCollection
    private List<Long> ticketsIds;

    private Double amount;

    private PaymentStatuses status;

    @CreatedDate
    private LocalDateTime paymentDate;

    public Payment() {
    }

    public Payment(CreditCardDetails customer, List<Long> ticketsIds, Double amount, PaymentStatuses status) {
        this.customer = customer;
        this.ticketsIds = ticketsIds;
        this.amount = amount;
        this.status = status;
    }

    public PaymentStatuses getStatus() {
        return status;
    }

    public void setStatus(PaymentStatuses status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CreditCardDetails getCustomer() {
        return customer;
    }

    public void setCustomer(CreditCardDetails customer) {
        this.customer = customer;
    }

    public List<Long> getTicketsIds() {
        return ticketsIds;
    }

    public void setTicketsIds(List<Long> ticketsIds) {
        this.ticketsIds = ticketsIds;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
}