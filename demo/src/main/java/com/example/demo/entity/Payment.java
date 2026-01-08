package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;


@Entity
public class Payment implements Serializable{
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer paymentId;
private String paymentStatus;
private Double amount;
@Transient // Won't be persisted in DB
private String tempNote;

@ManyToOne
@JoinColumn(name="user_id")
private Users users;
public Payment() {
	super();
}

	
public Integer getPaymentId() {
	return paymentId;
}


public void setPaymentId(Integer paymentId) {
	this.paymentId = paymentId;
}


public String getPaymentStatus() {
	return paymentStatus;
}


public void setPaymentStatus(String paymentStatus) {
	this.paymentStatus = paymentStatus;
}


public Double getAmount() {
	return amount;
}


public void setAmount(Double amount) {
	this.amount = amount;
}


public String getTempNote() {
	return tempNote;
}


public void setTempNote(String tempNote) {
	this.tempNote = tempNote;
}


public Users getUsers() {
	return users;
}


public void setUsers(Users users) {
	this.users = users;
}


public static long getSerialversionuid() {
	return serialVersionUID;
}


@Override
public String toString() {
	return "Payment [paymentId=" + paymentId + ", paymentStatus=" + paymentStatus + ", amount=" + amount + "]";
}

}
