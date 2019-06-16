package com.ibm.payments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.payments.exception.ApiException;
import com.ibm.payments.model.PaymentRequest;
import com.ibm.payments.model.Payments;
import com.ibm.payments.model.User;
import com.ibm.payments.service.PaymentsService;

@RestController
public class PaymentsController {

	@Autowired
	private PaymentsService paymentService;


	@RequestMapping(value = { "/trainings/payment" }, method = RequestMethod.POST)
	public @ResponseBody Payments createUser(@RequestBody PaymentRequest paymentRequest) throws ApiException {


		if (paymentRequest == null) {
			throw new ApiException("API_ERROR", "Payment Request Not Passed.");
		}

		return paymentService.makePayment(paymentRequest);
	}

	/*@RequestMapping(value = { "/v1/training/{training_id}/payment" }, method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable int id) throws ApiException {

		// Validate Login request

		if (StringUtils.isEmpty(id)) {
			throw new ApiException("API_ERROR", "Please provide User Id.");
		}
		return paymentService.findUserById(id);
	}*/

}