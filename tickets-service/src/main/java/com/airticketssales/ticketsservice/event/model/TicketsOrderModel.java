package com.airticketssales.ticketsservice.event.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class TicketsOrderModel {
    private List<Long> ticketsIds;

    private Double cost;

    private String name;

    private String cardNo;

    public TicketsOrderModel(List<Long> ticketsIds, Double cost, String name, String cardNo) {
        this.ticketsIds = ticketsIds;
        this.cost = cost;
        this.name = name;
        this.cardNo = cardNo;
    }

    public List<Long> getTicketsIds() {
        return ticketsIds;
    }

    public void setTicketsIds(List<Long> ticketsIds) {
        this.ticketsIds = ticketsIds;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

}
