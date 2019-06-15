package com.ibm.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.payments.model.Payments;
import com.ibm.payments.model.User;


@Repository("paymentsRepository")
public interface PaymentsRepository extends JpaRepository<Payments, Long> {
 
}