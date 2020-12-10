package com.airticketssales.salesservice.service;

import com.airticketssales.salesservice.domain.CreditCardDetails;
import com.airticketssales.salesservice.domain.Payment;
import com.airticketssales.salesservice.domain.PaymentStatuses;
import com.airticketssales.salesservice.event.model.TicketsOrderModel;
import com.airticketssales.salesservice.event.source.PaymentSuccessSource;
import com.airticketssales.salesservice.repository.CreditCardDetailsRepository;
import com.airticketssales.salesservice.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{
    private CreditCardDetailsRepository creditCardDetailsRepository;
    private PaymentRepository paymentRepository;
    private PaymentSuccessSource paymentSuccessSource;

    public PaymentServiceImpl(CreditCardDetailsRepository creditCardDetailsRepository, PaymentRepository paymentRepository, PaymentSuccessSource paymentSuccessSource) {
        this.creditCardDetailsRepository = creditCardDetailsRepository;
        this.paymentRepository = paymentRepository;
        this.paymentSuccessSource = paymentSuccessSource;
    }

    @Override
    public void addPaymentRecord(TicketsOrderModel ticketsOrderModel) {
        CreditCardDetails creditCardDetails = new CreditCardDetails(ticketsOrderModel.getName(), ticketsOrderModel.getCardNo());
        Payment payment = new Payment(creditCardDetails, ticketsOrderModel.getTicketsIds(), ticketsOrderModel.getCost(), PaymentStatuses.SUCCESS);
        creditCardDetailsRepository.save(creditCardDetails);
        paymentRepository.save(payment);

        paymentSuccessSource.publishPaymentSuccess(PaymentStatuses.SUCCESS.toString(), ticketsOrderModel.getTicketsIds());
    }
}
