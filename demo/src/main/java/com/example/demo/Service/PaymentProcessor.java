package com.example.demo.Service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.PaymentRepo;
import com.example.demo.entity.Payment;

@Service
public class PaymentProcessor {
	
	private final PaymentRepo paymentRepo;

	public PaymentProcessor(PaymentRepo paymentRepo) {
		super();
		this.paymentRepo = paymentRepo;
	}
	
	@Async("paymentExecutor")
    public void processPayment(Integer paymentId) {

	Payment payment= paymentRepo.findById(paymentId).orElseThrow(()->new RuntimeException("payment not found"));
	int attempts=0;
	int maxAttempts=3;
	
	if(attempts<maxAttempts) {
		try {
			attempts++;
			Thread.sleep(3000);
			payment.setPaymentStatus("success");
			paymentRepo.save(payment);
		return;
	}
		catch(Exception e) {
		System.out.println("attempts exceeded");
		}
		if(attempts==maxAttempts) {
			payment.setPaymentStatus("failed");
					paymentRepo.save(payment);
		}
	}
	}
}
