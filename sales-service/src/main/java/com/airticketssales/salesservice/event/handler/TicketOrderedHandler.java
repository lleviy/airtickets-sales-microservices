package com.airticketssales.salesservice.event.handler;

import com.airticketssales.salesservice.event.model.TicketsOrderModel;
import com.airticketssales.salesservice.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class TicketOrderedHandler {
    private PaymentService paymentService;

    private static final Logger logger = LoggerFactory.getLogger(TicketOrderedHandler.class);

    public TicketOrderedHandler(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Bean
    public Consumer<TicketsOrderModel> getTicketOrder(){
        return order -> {
            logger.info("receive: " + order.getCardNo());
            paymentService.addPaymentRecord(order);
        };
    }
}
