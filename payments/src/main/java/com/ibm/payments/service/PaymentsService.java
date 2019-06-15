package com.ibm.payments.service;

import com.ibm.payments.exception.ApiException;
import com.ibm.payments.model.PaymentRequest;
import com.ibm.payments.model.Payments;

public interface PaymentsService {

	public Payments makePayment(PaymentRequest paymentRequest) throws ApiException;
}
