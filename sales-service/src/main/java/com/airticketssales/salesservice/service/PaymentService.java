package com.airticketssales.salesservice.service;

import com.airticketssales.salesservice.event.model.TicketsOrderModel;

import java.util.List;

public interface PaymentService {
    void addPaymentRecord(TicketsOrderModel ticketsOrderModel);
}
