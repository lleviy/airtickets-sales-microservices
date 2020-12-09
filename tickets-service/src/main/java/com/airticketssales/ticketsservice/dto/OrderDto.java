package com.airticketssales.ticketsservice.dto;

import org.springframework.data.annotation.ReadOnlyProperty;

import java.util.List;

public class OrderDto {
    private List<TicketPurchaseDto> tickets;

    private String cardNo;

    private String customerName;

    @ReadOnlyProperty
    private Double cost;

    public OrderDto(List<TicketPurchaseDto> tickets, String cardNo, String customerName) {
        this.tickets = tickets;
        this.cardNo = cardNo;
        this.customerName = customerName;
    }

    public List<TicketPurchaseDto> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketPurchaseDto> tickets) {
        this.tickets = tickets;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
