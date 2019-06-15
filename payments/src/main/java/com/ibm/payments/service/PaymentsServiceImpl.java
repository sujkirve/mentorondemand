package com.ibm.payments.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibm.payments.exception.ApiException;
import com.ibm.payments.model.Error;
import com.ibm.payments.model.PaymentRequest;
import com.ibm.payments.model.Payments;
import com.ibm.payments.model.Trainings;
import com.ibm.payments.model.User;
import com.ibm.payments.repository.PaymentsRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Service("paymentService")
public class PaymentsServiceImpl implements PaymentsService {


	@Autowired
	PaymentsRepository paymentsRepository;
	
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EurekaClient eurekaClient;
    
    
	@Override
	public Payments makePayment(PaymentRequest paymentRequest) throws ApiException {
		
		// Mentor Details
		int mentorId = paymentRequest.getMentorId();
		Application application = eurekaClient.getApplication("users-api");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "users/" + mentorId;
        System.out.println("URL" + url);
        User mentor = restTemplate.getForObject(url, User.class);
        if(mentor==null) {
        	throw new ApiException("API_ERROR", "Mentor Not Found");
        }
        
        // Candidate Details
        String candidate_get_url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "users/" + mentorId;
        System.out.println("Candidate URL" + candidate_get_url);
        User candidate = restTemplate.getForObject(candidate_get_url, User.class);
        if(candidate==null) {
        	throw new ApiException("API_ERROR", "Mentor Not Found");
        }
        
        // Training Details
        int trainingId = paymentRequest.getMentorId();
		Application traningsApplication = eurekaClient.getApplication("tranings-api");
        InstanceInfo trainingInstanceInfo = traningsApplication.getInstances().get(0);
        String training_url = "http://" + trainingInstanceInfo.getIPAddr() + ":" + trainingInstanceInfo.getPort() + "/" + "users/" + trainingId;
        System.out.println("Traning URL" + training_url);
        Trainings trainings = restTemplate.getForObject(training_url, Trainings.class);
        if(trainings==null) {
        	throw new ApiException("API_ERROR", "Mentor Not Found");
        }
        
        Payments payments = new Payments();
        payments.setCandidate(candidate);
        payments.setMentor(mentor);
        payments.setTraining(trainings);
        payments.setAmount(paymentRequest.getAmount());
        
        
		return paymentsRepository.save(payments);
	}

}
