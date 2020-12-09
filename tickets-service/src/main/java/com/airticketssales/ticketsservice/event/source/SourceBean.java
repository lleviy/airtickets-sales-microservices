package com.airticketssales.ticketsservice.event.source;

import com.airticketssales.ticketsservice.dto.OrderDto;
import com.airticketssales.ticketsservice.dto.TicketPurchaseDto;
import com.airticketssales.ticketsservice.event.model.TicketsOrderModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SourceBean {
    private Processor source;

    private static final Logger logger = LoggerFactory.getLogger(SourceBean.class);

    public SourceBean(Processor source) {
        this.source = source;
    }

    public void sendTicketOrder(List<Long> ticketsIds, String customerName, String cardNo, Double cost){
        TicketsOrderModel ticketsOrderModel = new TicketsOrderModel(ticketsIds, cost, customerName, cardNo);

        logger.info("Sending TicketOrderModel");

        source.output().send(MessageBuilder.withPayload(ticketsOrderModel).build());
    }
}
