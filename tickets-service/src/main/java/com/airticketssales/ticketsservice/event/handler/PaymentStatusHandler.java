package com.airticketssales.ticketsservice.event.handler;

import com.airticketssales.ticketsservice.event.model.PaymentStatusModel;
import com.airticketssales.ticketsservice.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class PaymentStatusHandler {
    private TicketService ticketService;

    private static final Logger logger = LoggerFactory.getLogger(PaymentStatusHandler.class);

    public PaymentStatusHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Bean
    public Consumer<PaymentStatusModel> getPaymentStatus(){
        return paymentStatusModel -> {
            logger.info("Get payment status {} for tickets: {}", paymentStatusModel.getPaymentStatus(), paymentStatusModel.getTicketsIds().toString());
            switch (paymentStatusModel.getPaymentStatus()){
                case "SUCCESS":
                    // отправляем юзеру билеты на почту
                    break;
                case "FAIL":
                    // удаляем данные о пассажирах из заказанных билетов
                    break;
                default:
                    logger.error("Received an UNKNOWN status from the payment service");
                    break;
            }
        };
    }
}
