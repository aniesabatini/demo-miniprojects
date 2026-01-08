package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.PaymentService;
import com.example.demo.entity.Payment;
import com.example.demo.entity.Users;
@RequestMapping("/payment")
@RestController
public class PaymentController {
	private final PaymentService paymentService;
	
	public PaymentController(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}
	
	@GetMapping("/{paymentId}")
/*	public ResponseEntity<Payment> getPaymentById(@PathVariable Integer paymentId) {
		Optional opt=paymentService.findPaymentById(paymentId);
		if(opt.isPresent()) {
			return ResponseEntity.ok(opt.get())
					};
			else {
				return ResponseEntity.notFound().build();
			} 
		} */
	public Optional<Payment> getPaymentById(@PathVariable Integer paymentId){
		return paymentService.findPaymentById(paymentId);
	}
	
	@GetMapping("/all")
	public List<Payment> getAllPayment() {
		return paymentService.findAll();
	}
	
	@PostMapping("/create/{userId}")
	public Payment createPayment(@PathVariable Integer userId,@RequestBody Payment payment) {
		return paymentService.save(userId,payment);
	}
	}


