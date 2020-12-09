package com.airticketssales.salesservice.event.source;

import com.airticketssales.salesservice.event.model.PaymentStatusModel;
import com.airticketssales.salesservice.event.model.TicketsOrderModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentSuccessSource {
    private Source source;

    private static final Logger logger = LoggerFactory.getLogger(PaymentSuccessSource.class);

    public PaymentSuccessSource(Source source) {
        this.source = source;
    }

    public void publishPaymentSuccess(String status, List<Long> ticketsIds){
        PaymentStatusModel paymentStatusModel = new PaymentStatusModel(ticketsIds, status);
        logger.info("Sending payment status: " + status);

        source.output().send(MessageBuilder.withPayload(paymentStatusModel).build());
    }
}
