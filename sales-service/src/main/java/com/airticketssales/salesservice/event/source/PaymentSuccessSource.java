package com.airticketssales.salesservice.event.source;

import com.airticketssales.salesservice.event.model.PaymentStatusModel;
import com.airticketssales.salesservice.event.model.TicketsOrderModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentSuccessSource {

    private StreamBridge streamBridge;

    public PaymentSuccessSource(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    private static final Logger logger = LoggerFactory.getLogger(PaymentSuccessSource.class);

    public void publishPaymentSuccess(String status, List<Long> ticketsIds){
        PaymentStatusModel paymentStatusModel = new PaymentStatusModel(ticketsIds, status);
        logger.info("Sending payment status: " + status);
        streamBridge.send("publishPaymentSuccess-out-0", paymentStatusModel);
    }
}
