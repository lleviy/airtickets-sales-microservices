package com.airticketssales.ticketsservice.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class TicketPurchaseDto {
    private Long ticketId;

    private String passengerName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate passengerBirthDate;

    private String passengerDocumentNo;

    public TicketPurchaseDto(Long ticketId, String passengerName, LocalDate passengerBirthDate, String passengerDocumentNo) {
        this.ticketId = ticketId;
        this.passengerName = passengerName;
        this.passengerBirthDate = passengerBirthDate;
        this.passengerDocumentNo = passengerDocumentNo;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public LocalDate getPassengerBirthDate() {
        return passengerBirthDate;
    }

    public void setPassengerBirthDate(LocalDate passengerBirthDate) {
        this.passengerBirthDate = passengerBirthDate;
    }

    public String getPassengerDocumentNo() {
        return passengerDocumentNo;
    }

    public void setPassengerDocumentNo(String passengerDocumentNo) {
        this.passengerDocumentNo = passengerDocumentNo;
    }
}
