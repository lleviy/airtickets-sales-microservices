package com.airticketssales.salesservice.event.handler;

import com.airticketssales.salesservice.event.model.TicketsOrderModel;
import com.airticketssales.salesservice.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
public class TicketOrderedHandler {
    private PaymentService paymentService;

    private static final Logger logger = LoggerFactory.getLogger(TicketOrderedHandler.class);

    public TicketOrderedHandler(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

//    @StreamListener(Processor.INPUT)
//    public void getTicketOrder(TicketsOrderModel ticketsOrderModel){
//        logger.info("Get ticket order");
//        paymentService.addPaymentRecord(ticketsOrderModel);
//    }
}
