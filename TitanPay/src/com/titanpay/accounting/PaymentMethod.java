package com.titanpay.accounting;

import javax.persistence.Entity;

@Entity
public abstract class PaymentMethod implements java.io.Serializable{

	// Constructor
	public PaymentMethod(String fullName) {
		this.fullName = fullName;
	}
	
	protected String fullName;
	
	public abstract String pay(double amt);
	
}
