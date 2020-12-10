package com.airticketssales.ticketsservice.event.source;

import com.airticketssales.ticketsservice.event.model.TicketsOrderModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Source {
    StreamBridge streamBridge;

    private static final Logger logger = LoggerFactory.getLogger(Source.class);

    public Source(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void sendTicketOrder(List<Long> ticketsIds, String customerName, String cardNo, Double cost){
        logger.info("Sending ticket order");
        streamBridge.send("sendTicketOrder-out-0", new TicketsOrderModel(ticketsIds, cost, customerName, cardNo));
    }
}
