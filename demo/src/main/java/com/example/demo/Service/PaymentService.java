package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.PaymentRepo;
import com.example.demo.Repository.UserRepo;
import com.example.demo.entity.Payment;
import com.example.demo.entity.Users;

import jakarta.transaction.Transactional;

@Service

public class PaymentService {

	
	private final PaymentRepo paymentRepo;
	private final UserRepo userRepo;
	private final PaymentProcessor paymentProcessor;
	
	

	
	public PaymentService(PaymentRepo paymentRepo, UserRepo userRepo, PaymentProcessor paymentProcessor) {
		super();
		this.paymentRepo = paymentRepo;
		this.userRepo = userRepo;
		this.paymentProcessor = paymentProcessor;
	}

	public Optional<Payment> findPaymentById(Integer paymentId) {
		// TODO Auto-generated method stub
		return paymentRepo.findById(paymentId);
	}

	public List<Payment> findAll() {
		// TODO Auto-generated method stub
		return paymentRepo.findAll();
	}

	public Payment save(Integer userId,Payment payment) {
		// TODO Auto-generated method stub
		Users user =userRepo.findById(userId).orElseThrow(()->new RuntimeException("user not found"));
		
		payment.setUsers(user);
	//	payment.setPaymentStatus("pending");
		Payment savedPayment=paymentRepo.save(payment);
		paymentProcessor.processPayment(savedPayment.getPaymentId());
		 return paymentRepo.save(payment);
	}


	

}
