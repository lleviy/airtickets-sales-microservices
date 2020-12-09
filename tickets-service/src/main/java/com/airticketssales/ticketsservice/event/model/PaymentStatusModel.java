package com.airticketssales.ticketsservice.event.model;

import java.util.List;

public class PaymentStatusModel {
    private List<Long> ticketsIds;

    private String paymentStatus;

    public PaymentStatusModel(List<Long> ticketsIds, String paymentStatus) {
        this.ticketsIds = ticketsIds;
        this.paymentStatus = paymentStatus;
    }

    public List<Long> getTicketsIds() {
        return ticketsIds;
    }

    public void setTicketsIds(List<Long> ticketsIds) {
        this.ticketsIds = ticketsIds;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
